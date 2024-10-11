package com.enesbayram.jwt;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.enesbayram.exception.BaseException;
import com.enesbayram.exception.ErrorMessage;
import com.enesbayram.exception.MessageType;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter{
	
	private final JWTService jwtService;
	
	private final UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String header = request.getHeader("Authorization");
		String token;
		String username;
		
		if(header==null) {
			filterChain.doFilter(request, response);;
			return;
		}
		token = header.substring(7);
		try {
		 username=	jwtService.getUsernameByToken(token);
			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				if(userDetails!=null && jwtService.isTokenExpired(token)) {
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
					authenticationToken.setDetails(userDetails);
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			}
		}
		catch(ExpiredJwtException ex) {
			throw new BaseException(new ErrorMessage(MessageType.TOKEN_IS_EXPIRED, ex.getMessage()));
		}
		catch (Exception e) {
			throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION, e.getMessage()));
		}
		filterChain.doFilter(request, response);
	}

}
