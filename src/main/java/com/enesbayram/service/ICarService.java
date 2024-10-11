package com.enesbayram.service;

import com.enesbayram.dto.DtoCar;
import com.enesbayram.dto.DtoCarIU;

public interface ICarService {

	public DtoCar saveCar(DtoCarIU input);
}
