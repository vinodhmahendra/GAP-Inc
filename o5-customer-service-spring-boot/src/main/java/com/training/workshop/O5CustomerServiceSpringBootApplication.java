package com.training.workshop;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.training.workshop.model.Customer;
import com.training.workshop.services.CustomerService;

@SpringBootApplication
public class O5CustomerServiceSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext container =  SpringApplication.run(O5CustomerServiceSpringBootApplication.class);
		
		
		CustomerService customerService = container.getBean("customerService", CustomerService.class);
		
		List<Customer> loadedCustomers = customerService.retrieveAllCustomers();
		
		loadedCustomers.forEach(customer -> System.out.println(customer.getFirstName()));
	}

}
