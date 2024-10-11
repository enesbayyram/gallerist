package com.enesbayram.service.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.enesbayram.dto.CurrenyRatesResponse;
import com.enesbayram.exception.BaseException;
import com.enesbayram.exception.ErrorMessage;
import com.enesbayram.exception.MessageType;
import com.enesbayram.service.ICurrenyRatesService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CurrenyRatesServiceImpl implements ICurrenyRatesService {

	@Override
	public CurrenyRatesResponse getCurrenyRates(String startDate, String endDate) {
		String rootPath = "https://evds2.tcmb.gov.tr/service/evds/";
		String series = "TP.DK.USD.A";
		String type = "json";

		String endPoint = rootPath + "series=" + series + "&startDate=" + startDate + "&endDate=" + endDate + "&type="
				+ type;

		HttpHeaders headers = new HttpHeaders();
		headers.set("key", "XsBxAxzaVo");

		HttpEntity<?> htpEntity = new HttpEntity<>(headers);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<CurrenyRatesResponse> response = restTemplate.exchange(endPoint, HttpMethod.GET, htpEntity,
					new ParameterizedTypeReference<CurrenyRatesResponse>() {
					});
			if (!response.getStatusCode().is2xxSuccessful()) {
				throw new BaseException(
						new ErrorMessage(MessageType.CURRENY_RATES_OCCURED, response.getBody().toString()));
			}
			return response.getBody();
		} catch (Exception e) {
			throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION, e.getMessage()));
		}
	}

}
