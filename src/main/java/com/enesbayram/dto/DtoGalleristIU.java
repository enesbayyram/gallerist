package com.enesbayram.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoGalleristIU {

	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotNull
	private Long addressId;
}
