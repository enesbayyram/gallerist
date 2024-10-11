package com.enesbayram.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.enesbayram.dto.DtoCar;
import com.enesbayram.dto.DtoCarIU;
import com.enesbayram.model.Car;
import com.enesbayram.repository.CarRepository;
import com.enesbayram.service.ICarService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements ICarService {

	private final CarRepository carRepository;

	private Car createCar(DtoCarIU input) {
		Car car = new Car();
		car.setCreateTime(new Date());

		BeanUtils.copyProperties(input, car);

		return car;
	}

	@Override
	public DtoCar saveCar(DtoCarIU input) {
		DtoCar dtoCar = new DtoCar();

		Car savedCar = carRepository.save(createCar(input));
		BeanUtils.copyProperties(savedCar, dtoCar);

		return dtoCar;
	}

}
