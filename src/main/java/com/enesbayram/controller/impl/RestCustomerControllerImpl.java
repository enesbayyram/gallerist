package com.enesbayram.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enesbayram.controller.IRestCustomerController;
import com.enesbayram.controller.RootEntity;
import com.enesbayram.dto.DtoCustomer;
import com.enesbayram.dto.DtoCustomerIU;
import com.enesbayram.service.ICustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/customer")
public class RestCustomerControllerImpl extends RestBaseController implements IRestCustomerController{
	
	private final ICustomerService customerService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU input) {
		return ok(customerService.saveCustomer(input));
	}

}
