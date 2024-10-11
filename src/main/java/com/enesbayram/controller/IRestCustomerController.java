package com.enesbayram.controller;

import com.enesbayram.dto.DtoCustomer;
import com.enesbayram.dto.DtoCustomerIU;

public interface IRestCustomerController {

	public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU input);
}
