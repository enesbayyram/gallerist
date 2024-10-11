package com.enesbayram.controller;

import com.enesbayram.dto.DtoSaledCar;
import com.enesbayram.dto.DtoSaledCarIU;

public interface IRestSaledCarController {

	public RootEntity<DtoSaledCar> buyCar(DtoSaledCarIU input);
}
