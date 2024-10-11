package com.enesbayram.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCustomerIU {

	private String firstName;

	private String lastName;

	private String tckn;

	private Date birthOfDate;

	@NotNull
	private Long addressId;

	@NotNull
	private Long accountId;
}
