package com.training.workshop.repository;

import java.util.ArrayList;
import java.util.List;

import com.training.workshop.model.Customer;

public class ListCustomerRepositoryImpl implements CustomerRepository{
	
	private static List<Customer> customers = new ArrayList<>();

	static {
		customers.add(new Customer(1, "vinodh", "mahendra", "vinodh@pivotal.io"));
		customers.add(new Customer(2, "Bhavya", "Vinodh", "bhavya@collins.com"));
		customers.add(new Customer(3, "samarth", "vishnu", "samarth.vishnu@gmail.com"));
	}
	@Override
	public List<Customer> getAllCustomers() {
		return customers;
	}

}
