package com.training.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @SpringBootApplication (short cut ) = @Configuration + @EnableAutoConfiguration + @ComponentScan
@SpringBootApplication
public class O7SpringBootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(O7SpringBootWebApplication.class, args);
	}

//	@RequestMapping(path = "/",method = RequestMethod.GET)
	@GetMapping("/")
	public String greetings() {
		return "Hello World!";
	}
	
	@GetMapping("/customers")
	public Customer getCustomer() {
		return new Customer("vinodh", "mahendra");
	}
}
