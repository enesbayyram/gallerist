package com.enesbayram.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrenyRatesResponse {
	
	@JsonProperty("totalCount")
	private Long totalCount;
	
	@JsonProperty("items")
	private List<CurrenyRatesItems> items;
	
}
