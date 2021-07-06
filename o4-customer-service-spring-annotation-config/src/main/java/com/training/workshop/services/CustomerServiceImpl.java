package com.training.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.workshop.model.Customer;
import com.training.workshop.repository.CustomerRepository;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

	//depends on customerRepository
	@Autowired
	private CustomerRepository customerRepository;
	
	//explicit define a default constructor
	public CustomerServiceImpl() {
		super();
	}
	
//	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("spring called a constructor to inject a customerRepository");
		this.customerRepository = customerRepository;
	}
	
	
//	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("spring called a setter method to inject a customerRepository");
		this.customerRepository = customerRepository;
	}
	@Override
	public List<Customer> retrieveAllCustomers() {
		return customerRepository.getAllCustomers();
	}

}
