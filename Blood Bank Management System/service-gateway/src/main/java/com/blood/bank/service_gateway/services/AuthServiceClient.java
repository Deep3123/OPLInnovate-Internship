package com.blood.bank.service_gateway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AuthServiceClient {
//	@Autowired
//	private WebClient.Builder webClientBuilder;

	private final WebClient webClient;

	// Inject the WebClient.Builder from Spring context
	public AuthServiceClient(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://SERVICE-AUTH").build(); // Set the base URL for your auth
																					// service
	}

	// Non-blocking token validation using WebClient
	public Mono<Boolean> validateToken(String token) {
		System.err.println("Validate token method executed.");
		return webClient.get().uri("/auth/validate-token").header("Authorization", "Bearer " + token).retrieve()
				.bodyToMono(Boolean.class); // Return Mono<Boolean> asynchronously
	}

	// Non-blocking login using WebClient
	public Mono<String> login(String username, String password) {
		return webClient.post().uri("/auth/login").bodyValue(new LoginRequest(username, password)) // Sending a request
																									// body (use your
																									// LoginRequest DTO
																									// if necessary)
				.retrieve().bodyToMono(String.class); // Return Mono<String> asynchronously
	}

	// Add a DTO for the login request if necessary
	public static class LoginRequest {
		private String username;
		private String password;

		public LoginRequest(String username, String password) {
			this.username = username;
			this.password = password;
		}

		// Getters and Setters
	}
}
