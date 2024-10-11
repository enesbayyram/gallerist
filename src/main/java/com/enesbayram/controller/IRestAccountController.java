package com.enesbayram.controller;

import com.enesbayram.dto.DtoAccount;
import com.enesbayram.dto.DtoAccountIU;

public interface IRestAccountController {

	public RootEntity<DtoAccount> saveAccount(DtoAccountIU input);
}
