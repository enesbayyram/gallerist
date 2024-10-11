package com.enesbayram.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCustomer {

	private String firstName;
	
	private String lastName;
	
	private String tckn;
	
	private Date birthOfDate;
	
	private DtoAddress address;
	
	private DtoAccount account;
}
