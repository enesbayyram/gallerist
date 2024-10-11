package com.enesbayram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enesbayram.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
