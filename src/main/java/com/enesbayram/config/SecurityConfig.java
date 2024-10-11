package com.enesbayram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.enesbayram.jwt.AuthEntryPoint;
import com.enesbayram.jwt.JWTAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final AuthenticationProvider authenticationProvider;
	
	private final JWTAuthenticationFilter jwtAuthenticationFilter;
	
	private final AuthEntryPoint authEntryPoint;
	
	public static final String AUTHENTICATE = "/authenticate";
	public static final String REGISTER = "/register";
	public static final String REFRESH_TOKEN = "/refreshToken";
	
	public String[] SWAGGER_PATHS = {
			"/swagger-ui/**",
			"/v3/api-docs/**",
			"/swagger-ui.html"
	};
	

	
	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests(request->
		request.requestMatchers(AUTHENTICATE , REGISTER , REFRESH_TOKEN).permitAll()
		.requestMatchers(SWAGGER_PATHS).permitAll()
		.anyRequest()
		.authenticated())
		.exceptionHandling().authenticationEntryPoint(authEntryPoint).and()
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authenticationProvider(authenticationProvider)
		.addFilterAfter(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
}
