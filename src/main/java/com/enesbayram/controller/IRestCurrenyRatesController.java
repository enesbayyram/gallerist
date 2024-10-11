package com.enesbayram.controller;

import com.enesbayram.dto.CurrenyRatesResponse;

public interface IRestCurrenyRatesController {

	public RootEntity<CurrenyRatesResponse> getCurrenyRates(String startDate , String endDate);
}
