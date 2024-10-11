package com.enesbayram.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enesbayram.controller.IRestSaledCarController;
import com.enesbayram.controller.RootEntity;
import com.enesbayram.dto.DtoSaledCar;
import com.enesbayram.dto.DtoSaledCarIU;
import com.enesbayram.service.ISaledCarService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/saled-car")
public class RestSaledCarControllerImpl extends RestBaseController implements IRestSaledCarController {
	
	private final ISaledCarService saledCarService;
	
	@PostMapping("/buyCar")
	@Override
	public RootEntity<DtoSaledCar> buyCar(@Valid @RequestBody DtoSaledCarIU input) {
		return ok(saledCarService.buyCar(input));
	}

	
}
