package com.enesbayram.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enesbayram.controller.IRestAddressController;
import com.enesbayram.controller.RootEntity;
import com.enesbayram.dto.DtoAddress;
import com.enesbayram.dto.DtoAddressIU;
import com.enesbayram.service.IAddressService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/api/address")
@RequiredArgsConstructor
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController{

	private final IAddressService addressService;
	
	@PostMapping(path = "/save")
	@Override
	public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU input) {
		return ok(addressService.saveAddress(input));
	}

}
