package com.training.workshop.services;

import java.util.List;

import com.training.workshop.model.Customer;
import com.training.workshop.repository.CustomerRepository;
import com.training.workshop.repository.ListCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {

	//depends on customerrepository
	private CustomerRepository customerRepository = new ListCustomerRepositoryImpl();
	@Override
	public List<Customer> retrieveAllCustomers() {
		return customerRepository.getAllCustomers();
	}

}
