package com.enesbayram.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enesbayram.controller.IRestAccountController;
import com.enesbayram.controller.RootEntity;
import com.enesbayram.dto.DtoAccount;
import com.enesbayram.dto.DtoAccountIU;
import com.enesbayram.service.IAccountService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/api/account")
@RequiredArgsConstructor
public class RestAccountControllerImpl extends RestBaseController implements IRestAccountController {

	private final IAccountService accountService;
	
	@PostMapping(path = "/save")
	@Override
	public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU input) {
		return ok(accountService.saveAccount(input));
	}

}
