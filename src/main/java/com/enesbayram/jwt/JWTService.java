package com.enesbayram.jwt;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

	public static final String SECRET_KEY = "5N+6yAw9UJlZGIE3ivXxkQlxnb9BauSkvcdSJ447DQE=";
	
	
	public String generateToken(UserDetails userDetails) {
		return Jwts.builder()
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+ 1000*60*60*2))
				.signWith(getKey(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	public <T> T exportToken(String token , Function<Claims, T> claimsFunc) {
		Claims claims = getClaims(token);
		return claimsFunc.apply(claims);
	}
	
	public String getUsernameByToken(String token) {
		return exportToken(token, Claims::getSubject);
	}
	
	public boolean isTokenExpired(String token) {
		Date expireDate = exportToken(token, Claims::getExpiration);
		return new Date().before(expireDate);
	}
	
	public Claims getClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getKey())
				.build()
				.parseClaimsJws(token).getBody();
	}
	
	public Key getKey() {
		byte[] decode = Decoders.BASE64.decode(SECRET_KEY);
		 return Keys.hmacShaKeyFor(decode);
	}
	
}
