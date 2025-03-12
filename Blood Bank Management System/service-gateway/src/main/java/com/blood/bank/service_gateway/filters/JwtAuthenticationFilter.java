//package com.blood.bank.service_gateway.filters;
//
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//import com.blood.bank.service_gateway.client.AuthServiceClient;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//	private final AuthServiceClient authServiceClient;
//
//	public JwtAuthenticationFilter(AuthServiceClient authServiceClient) {
//		this.authServiceClient = authServiceClient;
//	}
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, javax.servlet.http.HttpServletResponse response,
//			FilterChain filterChain) throws ServletException, IOException {
//
//		String authorizationHeader = request.getHeader("Authorization");
//
//		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//			String token = authorizationHeader.substring(7);
//
//			// Validate the token by calling the Auth Service
//			ResponseEntity<Void> validationResponse = authServiceClient.validateToken(token);
//
//			if (validationResponse.getStatusCode().is2xxSuccessful()) {
//				String username = jwtUtil.extractUsername(token);
//				SecurityContextHolder.getContext().setAuthentication(
//						new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(username,
//								null, new java.util.ArrayList<>()));
//			} else {
//				response.setStatus(401);
//				return; // Unauthorized
//			}
//		}
//
//		filterChain.doFilter(request, response);
//	}
//}
