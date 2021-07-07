package com.training.workshop.services;

import java.util.List;

import com.training.workshop.model.Customer;

public interface CustomerService {
	public List<Customer> retrieveAllCustomers();
	public Customer retrieveCustomerById(Integer theId);
	public Customer createCustomer(Customer theCustomer);
	public void removeCustomerById(Integer theId);
}
