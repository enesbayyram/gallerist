package com.enesbayram.service;

import com.enesbayram.dto.DtoSaledCar;
import com.enesbayram.dto.DtoSaledCarIU;

public interface ISaledCarService {

	public DtoSaledCar buyCar(DtoSaledCarIU input);
}
