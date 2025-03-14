package com.blood.bank.service_auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blood.bank.service_auth.domain.User;
import com.blood.bank.service_auth.repo.UserRepo;
import com.blood.bank.service_auth.util.JwtUtil;

@Service
public class AuthService {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserRepo userRepo;

	// Generate a JWT token for a given username
	public String generateToken(String username) {
		return jwtUtil.generateToken(username);
	}

	// Validate the JWT token
	public boolean validateToken(String token) {
		try {
			String username = jwtUtil.extractUserName(token);
			return !jwtUtil.isTokenExpired(token);
		} catch (Exception e) {
			return false;
		}
	}

	// Save the user and forward based on role
	public String saveUser(User user) {
		// First, create the user in the auth-service
		userRepo.save(user);

		// Generate the token for the user after saving the user
		String token = generateToken(user.getUsername());

		System.err.println(token);
		// Forward the user to the respective service based on the role
		if ("donor".equalsIgnoreCase(user.getRole())) {
			String response = forwardRequestToService("SERVICE-DONOR", "Donor/saveDonor", user, token);
			if (!"success".equalsIgnoreCase(response)) {
				throw new RuntimeException("Failed to create donor");
			}
		} else if ("admin".equalsIgnoreCase(user.getRole())) {
			String response = forwardRequestToService("SERVICE-ADMIN", "admin/create", user, token);
			if (!"success".equalsIgnoreCase(response)) {
				throw new RuntimeException("Failed to create admin");
			}
		} else if ("user".equalsIgnoreCase(user.getRole())) {
			String response = forwardRequestToService("SERVICE-USER", "user/create", user, token);
			if (!"success".equalsIgnoreCase(response)) {
				throw new RuntimeException("Failed to create user");
			}
		} else {
			throw new RuntimeException("Invalid role provided");
		}

		// Return a success message after successfully creating the user and forwarding
		// the request
		return "User created and forwarded to " + user.getRole() + " service with token: " + token;
	}

	// Helper method to forward the request with token using the exchange method
	private String forwardRequestToService(String serviceName, String url, User user, String token) {
		// Set headers for the request, including the authorization token
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Create the HTTP entity with the user data and headers
		HttpEntity<User> entity = new HttpEntity<>(user, headers);

		// Send the request using exchange() method with POST method and get the
		// response
		System.err.println(entity);
		
		ResponseEntity<String> response = restTemplate.exchange("http://" + serviceName + "/" + url, // The service URL
				HttpMethod.POST, // The HTTP method (POST in this case)
				entity, // The request entity containing body and headers
				String.class // The expected response body type
		);

		// Return the response body (assuming the response is a String)
		return response.getBody();
	}
}
