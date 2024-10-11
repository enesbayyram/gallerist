package com.enesbayram.controller.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enesbayram.controller.IRestCurrenyRatesController;
import com.enesbayram.controller.RootEntity;
import com.enesbayram.dto.CurrenyRatesResponse;
import com.enesbayram.service.ICurrenyRatesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/api/")
@RequiredArgsConstructor
public class RestCurrenyRatesControllerImpl extends RestBaseController implements IRestCurrenyRatesController{

	
	private final ICurrenyRatesService currenyRatesService;

	@GetMapping(path = "/currency-rates")
	@Override
	public RootEntity<CurrenyRatesResponse> getCurrenyRates(@RequestParam(value = "startDate") String startDate ,
															@RequestParam(value = "endDate") String endDate) {
		return ok(currenyRatesService.getCurrenyRates(startDate , endDate));
	}

}
