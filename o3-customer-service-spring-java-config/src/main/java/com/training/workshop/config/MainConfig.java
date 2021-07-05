package com.training.workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.workshop.repository.CustomerRepository;
import com.training.workshop.repository.ListCustomerRepositoryImpl;
import com.training.workshop.services.CustomerService;
import com.training.workshop.services.CustomerServiceImpl;

@Configuration
public class MainConfig {
	
	@Bean
	// default : bean name = method name
	public CustomerRepository customerRepository() {
		return new ListCustomerRepositoryImpl();
	}
	
	@Bean
	public CustomerService customerService() {
		CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository());
		
		//customerService.setCustomerRepository(customerRepository());
		
		return customerService;
	}

}
