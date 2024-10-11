package com.enesbayram.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enesbayram.controller.IRestGalleristCarController;
import com.enesbayram.controller.RootEntity;
import com.enesbayram.dto.DtoGalleristCar;
import com.enesbayram.dto.DtoGalleristCarIU;
import com.enesbayram.service.IGalleristCarService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/gallerist-car")
public class RestGalleristCarControllerImpl extends RestBaseController implements IRestGalleristCarController {
	
	
	private final IGalleristCarService galleristCarService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoGalleristCar> saveGalleristCar(@Valid @RequestBody DtoGalleristCarIU input) {
		return ok(galleristCarService.saveGalleristCar(input));
	}

	
	
}
