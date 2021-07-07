package com.training.workshop.repository;

import java.util.List;

import com.training.workshop.model.Customer;

public interface CustomerRepository {
	
	public List<Customer> getAllCustomers();
	public Customer saveCustomer(Customer theCustomer);
	public Customer getCustomer(Integer theId);
	public void deleteCustomer(Integer theId);

	// update
}
