package com.enesbayram.service;

import com.enesbayram.dto.DtoUser;
import com.enesbayram.jwt.AuthRequest;
import com.enesbayram.jwt.AuthResponse;
import com.enesbayram.jwt.RefreshTokenRequest;

public interface IAuthenticationService {

	 DtoUser register(AuthRequest request);
	 
	 AuthResponse authenticate(AuthRequest authRequest);
	 
	 AuthResponse refreshToken(RefreshTokenRequest request);
}
