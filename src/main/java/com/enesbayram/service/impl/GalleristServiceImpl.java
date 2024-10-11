package com.enesbayram.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.enesbayram.dto.DtoAddress;
import com.enesbayram.dto.DtoGallerist;
import com.enesbayram.dto.DtoGalleristIU;
import com.enesbayram.exception.BaseException;
import com.enesbayram.exception.ErrorMessage;
import com.enesbayram.exception.MessageType;
import com.enesbayram.model.Address;
import com.enesbayram.model.Gallerist;
import com.enesbayram.repository.AddressRepository;
import com.enesbayram.repository.GalleristRepository;
import com.enesbayram.service.IGalleristService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GalleristServiceImpl implements IGalleristService{
	
	
	private final GalleristRepository galleristRepository;
	
	private final AddressRepository addressRepository;
	
	public Gallerist createGallerist(DtoGalleristIU input) {
		Gallerist gallerist = new Gallerist();
		gallerist.setCreateTime(new Date());
		BeanUtils.copyProperties(input, gallerist);
		
		
		Optional<Address> optAddress = addressRepository.findById(input.getAddressId());
		if(optAddress.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, input.getAddressId().toString()));
		}
		gallerist.setAddress(optAddress.get());
		return gallerist;
	}
	
	@Override
	public DtoGallerist saveGallerist(DtoGalleristIU input) {
		DtoGallerist dtoGallerist = new DtoGallerist();
		DtoAddress dtoAddress = new DtoAddress();
		
		Gallerist gallerist = createGallerist(input);
		Gallerist savedGallerist = galleristRepository.save(gallerist);
		
		BeanUtils.copyProperties(savedGallerist, dtoGallerist);
		BeanUtils.copyProperties(savedGallerist.getAddress(), dtoAddress);
		
		dtoGallerist.setAddress(dtoAddress);
		return dtoGallerist;
	}

	
	
}

