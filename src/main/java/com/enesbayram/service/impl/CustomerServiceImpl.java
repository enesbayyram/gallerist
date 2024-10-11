package com.enesbayram.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.enesbayram.dto.DtoAccount;
import com.enesbayram.dto.DtoAddress;
import com.enesbayram.dto.DtoCustomer;
import com.enesbayram.dto.DtoCustomerIU;
import com.enesbayram.model.Account;
import com.enesbayram.model.Address;
import com.enesbayram.model.Customer;
import com.enesbayram.repository.AccountRepository;
import com.enesbayram.repository.AddressRepository;
import com.enesbayram.repository.CustomerRepository;
import com.enesbayram.service.ICustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

	private final AddressRepository addressRepository;

	private final AccountRepository accountRepository;

	private final CustomerRepository customerRepository;

	private Customer createCustomer(DtoCustomerIU input) {
		Customer customer = new Customer();
		customer.setCreateTime(new Date());
		BeanUtils.copyProperties(input, customer);

		Optional<Address> optAddress = addressRepository.findById(input.getAddressId());
		customer.setAddress(optAddress.get());

		Optional<Account> optAccount = accountRepository.findById(input.getAccountId());
		customer.setAccount(optAccount.get());

		return customer;
	}

	@Override
	public DtoCustomer saveCustomer(DtoCustomerIU input) {
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();
		DtoAccount dtoAccount = new DtoAccount();

		Customer savedCustomer = customerRepository.save(createCustomer(input));

		BeanUtils.copyProperties(savedCustomer, dtoCustomer);
		BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);
		BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);

		dtoCustomer.setAddress(dtoAddress);
		dtoCustomer.setAccount(dtoAccount);

		return dtoCustomer;
	}

}
