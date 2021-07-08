package com.training.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.workshop.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
//	@Query()
//	public Customer find();

}
