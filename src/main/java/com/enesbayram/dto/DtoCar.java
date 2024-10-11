package com.enesbayram.dto;

import java.math.BigDecimal;

import com.enesbayram.enums.CarStatusType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCar {

	private String plaka;
	
	private String brand;
	
	private String model;
	
	private Integer productionYear;
	
	private BigDecimal price;
	
	private BigDecimal damagePrice;
	
	private CarStatusType carStatusType;
}
