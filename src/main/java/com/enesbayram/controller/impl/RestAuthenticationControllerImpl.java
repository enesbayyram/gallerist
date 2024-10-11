package com.enesbayram.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enesbayram.controller.IRestAuthenticationController;
import com.enesbayram.controller.RootEntity;
import com.enesbayram.dto.DtoUser;
import com.enesbayram.jwt.AuthRequest;
import com.enesbayram.jwt.AuthResponse;
import com.enesbayram.jwt.RefreshTokenRequest;
import com.enesbayram.service.IAuthenticationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {

	private final IAuthenticationService authenticationService;
	
	
	@PostMapping("/register")
	@Override
	public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest request) {
		return ok(authenticationService.register(request));
	}


	@PostMapping("/authenticate")
	@Override
	public RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest request) {
		return ok(authenticationService.authenticate(request));
	}


	@PostMapping("/refreshToken")
	@Override
	public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
		return ok(authenticationService.refreshToken(request));
	}

}
