package com.blood.bank.service_gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.blood.bank.service_gateway.services.AuthServiceClient;
import reactor.core.publisher.Mono;

@Component
public class JwtGatewayFilter extends AbstractGatewayFilterFactory<JwtGatewayFilter.Config> {

	private final AuthServiceClient authServiceClient;

	public JwtGatewayFilter(@Lazy AuthServiceClient authServiceClient) {
		super(Config.class);
		this.authServiceClient = authServiceClient;
	}

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
			System.err.println(authHeader);
			if (authHeader != null && authHeader.startsWith("Bearer ")) {
				String jwtToken = authHeader.substring(7);

				return authServiceClient.validateToken(jwtToken).flatMap(isValid -> {
					if (isValid) {
						// Ensure this is non-blocking
						System.err.println("first");
						exchange.getRequest().mutate().header("Authorization", "Bearer " + jwtToken).build();
						return chain.filter(exchange);
					} else {
						System.err.println("second");
						exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
						return exchange.getResponse().setComplete();
					}
				}).switchIfEmpty(Mono.defer(() -> {
					System.err.println("Third");
					exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
					return exchange.getResponse().setComplete();
				}));
			} else {
				System.err.println("Fourth");
				exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
				return exchange.getResponse().setComplete();
			}
		};
	}

	public String getName() {
		return "JwtGatewayFilter";
	}

	public static class Config {
	}
}
