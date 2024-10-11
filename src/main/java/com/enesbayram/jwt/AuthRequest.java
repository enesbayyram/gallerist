package com.enesbayram.jwt;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {

	@NotEmpty(message = "username alanı boş olamaz")
	private String username;
	
	@NotEmpty(message = "password alanı boş olamaz")
	private String password;
}
