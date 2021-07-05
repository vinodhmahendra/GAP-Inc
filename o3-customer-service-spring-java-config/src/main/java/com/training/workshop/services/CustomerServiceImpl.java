package com.training.workshop.services;

import java.util.List;

import com.training.workshop.model.Customer;
import com.training.workshop.repository.CustomerRepository;
import com.training.workshop.repository.ListCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {

	//depends on customerRepository
	private CustomerRepository customerRepository;
	
	//explicit define a default constructor
	public CustomerServiceImpl() {
		super();
	}

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("spring called a constructor to inject a customerRepository");
		this.customerRepository = customerRepository;
	}
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("spring called a setter method to inject a customerRepository");
		this.customerRepository = customerRepository;
	}
	@Override
	public List<Customer> retrieveAllCustomers() {
		return customerRepository.getAllCustomers();
	}

}
