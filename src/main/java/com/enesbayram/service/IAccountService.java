package com.enesbayram.service;

import com.enesbayram.dto.DtoAccount;
import com.enesbayram.dto.DtoAccountIU;

public interface IAccountService {

	public DtoAccount saveAccount(DtoAccountIU input);
}
