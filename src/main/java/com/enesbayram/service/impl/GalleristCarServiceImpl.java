package com.enesbayram.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.enesbayram.dto.DtoAddress;
import com.enesbayram.dto.DtoCar;
import com.enesbayram.dto.DtoGallerist;
import com.enesbayram.dto.DtoGalleristCar;
import com.enesbayram.dto.DtoGalleristCarIU;
import com.enesbayram.exception.BaseException;
import com.enesbayram.exception.ErrorMessage;
import com.enesbayram.exception.MessageType;
import com.enesbayram.model.Car;
import com.enesbayram.model.Gallerist;
import com.enesbayram.model.GalleristCar;
import com.enesbayram.repository.CarRepository;
import com.enesbayram.repository.GalleristCarRepository;
import com.enesbayram.repository.GalleristRepository;
import com.enesbayram.service.ICarService;
import com.enesbayram.service.IGalleristCarService;
import com.enesbayram.service.IGalleristService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GalleristCarServiceImpl implements IGalleristCarService{
	
	private final GalleristCarRepository galleristCarRepository;
	
	private final GalleristRepository galleristRepository;
	
	private final CarRepository carRepository;
	
	private GalleristCar createGalleristCar(DtoGalleristCarIU input) {
		GalleristCar galleristCar = new GalleristCar();
		galleristCar.setCreateTime(new Date());
		
		Optional<Gallerist> optGallerist = galleristRepository.findById(input.getGalleristId());
		if(optGallerist.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, input.getGalleristId().toString()));
		}
		
		Optional<Car> optCar = carRepository.findById(input.getCarId());
		if(optCar.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, input.getCarId().toString()));
		}
		
		galleristCar.setGallerist(optGallerist.get());
		galleristCar.setCar(optCar.get());
		
		return galleristCar;
	}
	
	@Override
	public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU input) {
		DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
		DtoGallerist dtoGallerist = new DtoGallerist();
		DtoCar dtoCar  =new DtoCar();
		DtoAddress dtoAddress = new DtoAddress();
		
		GalleristCar savedGalleristCar = galleristCarRepository.save(createGalleristCar(input));
		BeanUtils.copyProperties(savedGalleristCar, dtoGalleristCar);
		BeanUtils.copyProperties(savedGalleristCar.getGallerist(), dtoGallerist);
		BeanUtils.copyProperties(savedGalleristCar.getCar(), dtoCar);
		
		BeanUtils.copyProperties(savedGalleristCar.getGallerist().getAddress(), dtoAddress);
		dtoGallerist.setAddress(dtoAddress);
		
		dtoGalleristCar.setGallerist(dtoGallerist);
		dtoGalleristCar.setCar(dtoCar);
		
		return dtoGalleristCar;
	}

}
