package com.enesbayram.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enesbayram.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
