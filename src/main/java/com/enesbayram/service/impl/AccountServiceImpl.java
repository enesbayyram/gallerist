package com.enesbayram.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.enesbayram.dto.DtoAccount;
import com.enesbayram.dto.DtoAccountIU;
import com.enesbayram.model.Account;
import com.enesbayram.repository.AccountRepository;
import com.enesbayram.service.IAccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

	private final AccountRepository accountRepository;

	@Override
	public DtoAccount saveAccount(DtoAccountIU input) {
		DtoAccount dtoAccount = new DtoAccount();

		Account account = new Account();
		account.setCreateTime(new Date());

		BeanUtils.copyProperties(input, account);

		Account savedAccount = accountRepository.save(account);
		BeanUtils.copyProperties(savedAccount, dtoAccount);
		return dtoAccount;
	}

}
