package com.enesbayram.controller;

import com.enesbayram.dto.DtoGalleristCar;
import com.enesbayram.dto.DtoGalleristCarIU;

public interface IRestGalleristCarController {
	
	public RootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU input);

}
