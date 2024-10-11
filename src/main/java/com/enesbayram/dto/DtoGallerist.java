package com.enesbayram.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoGallerist {

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private DtoAddress address;
}
