package com.training.workshop;

import java.util.List;

import com.training.workshop.model.Customer;
import com.training.workshop.services.CustomerService;
import com.training.workshop.services.CustomerServiceImpl;

public class Program {

	public static void main(String[] args) {
		
		CustomerService customerService = new CustomerServiceImpl();
		
		List<Customer> loadedCustomers = customerService.retrieveAllCustomers();
		
		loadedCustomers.forEach(customer -> System.out.println(customer.getFirstName()));

	}

}
