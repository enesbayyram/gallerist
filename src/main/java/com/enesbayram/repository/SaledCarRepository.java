package com.enesbayram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enesbayram.model.SaledCar;

@Repository
public interface SaledCarRepository extends JpaRepository<SaledCar, Long>{

}
