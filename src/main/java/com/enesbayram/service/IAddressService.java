package com.enesbayram.service;

import com.enesbayram.dto.DtoAddress;
import com.enesbayram.dto.DtoAddressIU;

public interface IAddressService {

	public DtoAddress saveAddress(DtoAddressIU request);
}
