package com.training.workshop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.workshop.config.MainConfig;
import com.training.workshop.model.Customer;
import com.training.workshop.services.CustomerService;

public class Program {

	public static void main(String[] args) {
		
	//	ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ApplicationContext container = new AnnotationConfigApplicationContext(MainConfig.class);
		//CustomerService customerService = new CustomerServiceImpl();
		CustomerService customerService = container.getBean("customerService", CustomerService.class);
		
		List<Customer> loadedCustomers = customerService.retrieveAllCustomers();
		
		loadedCustomers.forEach(customer -> System.out.println(customer.getFirstName()));

	}

}
