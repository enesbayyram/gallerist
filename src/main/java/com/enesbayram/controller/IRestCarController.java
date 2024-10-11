package com.enesbayram.controller;

import com.enesbayram.dto.DtoCar;
import com.enesbayram.dto.DtoCarIU;

public interface IRestCarController {

	public RootEntity<DtoCar> saveCar(DtoCarIU input);
}
