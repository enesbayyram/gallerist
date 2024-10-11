package com.enesbayram.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.enesbayram.dto.CurrenyRatesResponse;
import com.enesbayram.dto.DtoCar;
import com.enesbayram.dto.DtoCustomer;
import com.enesbayram.dto.DtoGallerist;
import com.enesbayram.dto.DtoSaledCar;
import com.enesbayram.dto.DtoSaledCarIU;
import com.enesbayram.enums.CarStatusType;
import com.enesbayram.exception.BaseException;
import com.enesbayram.exception.ErrorMessage;
import com.enesbayram.exception.MessageType;
import com.enesbayram.model.Account;
import com.enesbayram.model.Car;
import com.enesbayram.model.Customer;
import com.enesbayram.model.SaledCar;
import com.enesbayram.repository.AccountRepository;
import com.enesbayram.repository.CarRepository;
import com.enesbayram.repository.CustomerRepository;
import com.enesbayram.repository.GalleristRepository;
import com.enesbayram.repository.SaledCarRepository;
import com.enesbayram.service.ICurrenyRatesService;
import com.enesbayram.service.ISaledCarService;
import com.enesbayram.utils.DateUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaledCarServiceImpl implements ISaledCarService {

	private final SaledCarRepository saledCarRepository;

	private final CustomerRepository customerRepository;

	private final GalleristRepository galleristRepository;

	private final CarRepository carRepository;

	private final ICurrenyRatesService currenyRatesService;
	
	private final AccountRepository accountRepository;

	public BigDecimal remaningCustomerAmount(Customer customer, Car car) {
		BigDecimal customerUsdAmount = convertUSDCustomerAmount(customer);
		BigDecimal remaningCustomerAmount = customerUsdAmount.subtract(car.getPrice());

		return remaningCustomerAmount;
	}

	public BigDecimal convertUSDCustomerAmount(Customer customer) {
		CurrenyRatesResponse currenyRates = currenyRatesService.getCurrenyRates(
				DateUtils.getCurrentDateddMMYYYY(new Date()), DateUtils.getCurrentDateddMMYYYY(new Date()));

		BigDecimal customerAmount = customer.getAccount().getAmount();
		BigDecimal usd = new BigDecimal(currenyRates.getItems().get(0).getUsd());

		BigDecimal customerUsdAmount = customerAmount.divide(usd, 2, RoundingMode.HALF_UP);

		return customerUsdAmount;
	}

	public boolean checkAmount(Long customerId, Long carId) {
		Optional<Customer> optCustomer = customerRepository.findById(customerId);
		if (optCustomer.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, customerId.toString()));
		}

		Optional<Car> optCar = carRepository.findById(carId);
		if (optCar.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, carId.toString()));
		}

		Car car = optCar.get();
		
		BigDecimal customerUsdAmount = convertUSDCustomerAmount(optCustomer.get());
		if (customerUsdAmount.compareTo(car.getPrice()) == 0 || customerUsdAmount.compareTo(car.getPrice()) > 0) {
			return true;
		}
		return false;
	}

	private SaledCar createSaledCar(DtoSaledCarIU input) {
		SaledCar saledCar = new SaledCar();
		saledCar.setCreateTime(new Date());

		saledCar.setCustomer(customerRepository.findById(input.getCustomerId()).orElse(null));
		saledCar.setGallerist(galleristRepository.findById(input.getGalleristId()).orElse(null));
		saledCar.setCar(carRepository.findById(input.getCarId()).orElse(null));

		return saledCar;
	}

	@Override
	public DtoSaledCar buyCar(DtoSaledCarIU input) {
		if(!checkAmount(input.getCustomerId(), input.getCarId())) {
			throw new BaseException(new ErrorMessage(MessageType.MONEY_IS_NOT_ENOUGH, input.getCustomerId().toString()));
		}
		
		SaledCar savedSaledCar = saledCarRepository.save(createSaledCar(input));
		
		Car car = carRepository.findById(input.getCarId()).orElse(null);
		car.setCarStatusType(CarStatusType.SALED);
		carRepository.save(car);
		
		
		Account account= savedSaledCar.getCustomer().getAccount();
		account.setAmount(remaningCustomerAmount(savedSaledCar.getCustomer(), car));
		
		accountRepository.save(account);
		
		return toDTO(savedSaledCar);
	}
	
	
	public DtoSaledCar toDTO(SaledCar saledCar) {
		DtoSaledCar dtoSaledCar = new DtoSaledCar();
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoGallerist dtoGallerist  =new DtoGallerist();
		DtoCar dtoCar = new DtoCar();
		
		
		BeanUtils.copyProperties(saledCar.getCustomer(), dtoCustomer);
		BeanUtils.copyProperties(saledCar.getGallerist(), dtoGallerist);
		BeanUtils.copyProperties(saledCar.getCar(), dtoCar);
		
		dtoSaledCar.setCustomer(dtoCustomer);
		dtoSaledCar.setGallerist(dtoGallerist);
		dtoSaledCar.setCar(dtoCar);
		
		return dtoSaledCar;
		
		
	}

}
