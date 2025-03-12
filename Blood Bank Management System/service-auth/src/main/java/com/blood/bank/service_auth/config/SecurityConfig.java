package com.blood.bank.service_auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.blood.bank.service_auth.filter.JwtAuthenticationFilter;
import com.blood.bank.service_auth.repo.UserRepo;
import com.blood.bank.service_auth.util.JwtUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final JwtUtil jwtUtil;

	private final UserRepo userRepo;

	// Inject JwtUtil to be used in JwtAuthenticationFilter
	public SecurityConfig(JwtUtil jwtUtil, UserRepo userRepo) {
		this.jwtUtil = jwtUtil;
		this.userRepo = userRepo;
	}

	@Bean
	public SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception {
		http.csrf(c -> c.disable());
		http.authorizeHttpRequests(
				auth -> auth.requestMatchers("/auth/login", "/auth/validate-token", "/auth/save-user").permitAll()
						.anyRequest().authenticated());
		http.addFilterBefore(new JwtAuthenticationFilter(jwtUtil, userRepo),
				UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	// Bean to encrypt passwords (BCrypt)
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
