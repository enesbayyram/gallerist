package com.enesbayram.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.enesbayram.dto.DtoAddress;
import com.enesbayram.dto.DtoAddressIU;
import com.enesbayram.model.Address;
import com.enesbayram.repository.AddressRepository;
import com.enesbayram.service.IAddressService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements IAddressService {

	private final AddressRepository addressRepository;

	@Override
	public DtoAddress saveAddress(DtoAddressIU request) {
		DtoAddress dtoAddress = new DtoAddress();
		Address address = new Address();
		address.setCreateTime(new Date());

		BeanUtils.copyProperties(request, address);

		Address savedAddress = addressRepository.save(address);
		BeanUtils.copyProperties(savedAddress, dtoAddress);
		return dtoAddress;
	}

}
