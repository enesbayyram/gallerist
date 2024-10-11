package com.enesbayram.controller;

import com.enesbayram.dto.DtoUser;
import com.enesbayram.jwt.AuthRequest;
import com.enesbayram.jwt.AuthResponse;
import com.enesbayram.jwt.RefreshTokenRequest;

public interface IRestAuthenticationController {

	
	public RootEntity<DtoUser> register(AuthRequest request);
	
	public RootEntity<AuthResponse> authenticate(AuthRequest request);
	
	public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest request);
}
