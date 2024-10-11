package com.enesbayram.dto;

import java.math.BigDecimal;

import com.enesbayram.enums.CurrencyType;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAccountIU {

	@NotEmpty(message = "accountNo alanı boş bırakılamaz")
	private String accountNo;
	
	@NotEmpty(message = "iban alanı boş bırakılamaz")
	private String iban;
	
	@NotNull(message = "amount alanı boş bırakılamaz")
	private BigDecimal amount;
	
	@NotNull(message = "currenyType alanı boş bırakılamaz")
	private CurrencyType currencyType;
}
