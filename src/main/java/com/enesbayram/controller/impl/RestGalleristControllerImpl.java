package com.enesbayram.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enesbayram.controller.IRestGalleristController;
import com.enesbayram.controller.RootEntity;
import com.enesbayram.dto.DtoGallerist;
import com.enesbayram.dto.DtoGalleristIU;
import com.enesbayram.service.IGalleristService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/gallerist")
public class RestGalleristControllerImpl extends RestBaseController implements IRestGalleristController {
	
	private final IGalleristService galleristService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoGallerist> saveGallerist(@Valid @RequestBody DtoGalleristIU input) {
		return ok(galleristService.saveGallerist(input));
	}

}
