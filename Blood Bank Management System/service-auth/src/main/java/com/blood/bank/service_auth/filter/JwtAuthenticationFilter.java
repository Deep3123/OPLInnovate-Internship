package com.blood.bank.service_auth.filter;

import com.blood.bank.service_auth.domain.User;
import com.blood.bank.service_auth.repo.UserRepo;
import com.blood.bank.service_auth.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;
	private final UserRepo userRepo;

	@Autowired
	public JwtAuthenticationFilter(JwtUtil jwtUtil, UserRepo userRepo) {
		this.jwtUtil = jwtUtil;
		this.userRepo = userRepo;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// Extract JWT token from the request
		String token = getTokenFromRequest(request);

		if (token != null && !jwtUtil.isTokenExpired(token)) {
			// Extract username from the JWT token
			String username = jwtUtil.extractUserName(token);
			System.err.println(username);
			User user = userRepo.findByUsername(username);

			// Validate the token (you may have a validateToken method in JwtUtil)
			if (jwtUtil.validateToken(token, user)) { // You can pass actual userDetails if needed
				// Create the authentication object if not already set in SecurityContext
				if (SecurityContextHolder.getContext().getAuthentication() == null) {
					// Set the user authentication (you can load authorities or roles if needed)
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							username, user, null); // You can add authorities here if needed
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			}
		}

		// Continue with the filter chain
		filterChain.doFilter(request, response);
	}

	// Extract the JWT token from the Authorization header
	private String getTokenFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7); // Return the token without "Bearer " prefix
		}
		return null;
	}

}
