package com.enesbayram.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enesbayram.controller.IRestCarController;
import com.enesbayram.controller.RootEntity;
import com.enesbayram.dto.DtoCar;
import com.enesbayram.dto.DtoCarIU;
import com.enesbayram.service.ICarService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/api/car")
@RequiredArgsConstructor
public class RestCarControllerImpl extends RestBaseController implements IRestCarController{
	
	private final ICarService carService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoCar> saveCar(@RequestBody DtoCarIU input) {
		return ok(carService.saveCar(input));
	}

	
}
