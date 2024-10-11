package com.enesbayram.service;

import com.enesbayram.dto.CurrenyRatesResponse;

public interface ICurrenyRatesService {

	public CurrenyRatesResponse getCurrenyRates(String startDate , String endDate);
}
