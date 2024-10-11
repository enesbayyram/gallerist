package com.enesbayram.controller;

import com.enesbayram.dto.DtoAddress;
import com.enesbayram.dto.DtoAddressIU;

public interface IRestAddressController {

	public RootEntity<DtoAddress> saveAddress(DtoAddressIU input);
}
