package com.enesbayram.service;

import com.enesbayram.dto.DtoGalleristCar;
import com.enesbayram.dto.DtoGalleristCarIU;

public interface IGalleristCarService {

	public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU input);
}
