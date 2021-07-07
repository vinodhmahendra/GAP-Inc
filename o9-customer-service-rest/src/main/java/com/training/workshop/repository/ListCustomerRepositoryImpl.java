package com.training.workshop.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.training.workshop.model.Customer;

//@Repository , Default class name becomes bean name (eg) of bean listCustomerRepositoryImpl
@Repository(value = "customerRepository")
public class ListCustomerRepositoryImpl implements CustomerRepository{
	
	private static List<Customer> customers = new ArrayList<>();

	static {
		customers.add(new Customer(1, "vinodh", "mahendra", "vinodh@pivotal.io"));
		customers.add(new Customer(2, "Bhavya", "Vinodh", "bhavya@collins.com"));
		customers.add(new Customer(3, "samarth", "vishnu", "samarth.vishnu@gmail.com"));
	}
	private  static Integer customerCount = 3;
	@Override
	public List<Customer> getAllCustomers() {
		return customers;
	}
	@Override
	public Customer saveCustomer(Customer theCustomer) {
		if (theCustomer.getId() == null) {
			theCustomer.setId(++customerCount );
		}
		customers.add(theCustomer);
		return theCustomer;
	}
	@Override
	public Customer getCustomer(Integer theId) {
		for(Customer theCustomer : customers) {
			if (theCustomer.getId() == theId) {
				return theCustomer;
			}
		}
		return null;
	}
	@Override
	public void deleteCustomer(Integer theId) {
		Iterator<Customer> iterator = customers.iterator();
		while (iterator.hasNext()) {
			Customer theCustomer =  iterator.next();
			if ( theCustomer.getId() == theId) {
				iterator.remove();
			}
		}
	}

}
