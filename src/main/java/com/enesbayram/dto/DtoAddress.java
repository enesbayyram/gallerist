package com.enesbayram.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAddress {

	private Long id;
	
	private String city;

	private String district;
	
	private String neighborhood;
	
	private String street;
}
