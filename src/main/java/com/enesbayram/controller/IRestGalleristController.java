package com.enesbayram.controller;

import com.enesbayram.dto.DtoGallerist;
import com.enesbayram.dto.DtoGalleristIU;

public interface IRestGalleristController {

	public RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU input);
}
