package com.enesbayram.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAddressIU {

	@NotEmpty(message = "city alanı boş olamaz")
	private String city;

	@NotEmpty(message = "district alanı boş olamaz")
	private String district;
	
	@NotEmpty(message = "neighborhood alanı boş olamaz")
	private String neighborhood;
	
	@NotEmpty(message = "street alanı boş olamaz")
	private String street;
}
