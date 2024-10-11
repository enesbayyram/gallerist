package com.enesbayram.service;

import com.enesbayram.dto.DtoCustomer;
import com.enesbayram.dto.DtoCustomerIU;

public interface ICustomerService {

	public DtoCustomer saveCustomer(DtoCustomerIU input);

}
