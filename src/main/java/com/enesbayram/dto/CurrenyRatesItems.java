package com.enesbayram.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrenyRatesItems {

	@JsonProperty("Tarih")
	private String tarih;
	
	@JsonProperty("TP_DK_USD_A")
	private String usd;
	
	
}
