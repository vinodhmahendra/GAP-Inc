package com.training.workshop.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.workshop.model.Customer;

//@FeignClient(name = "cutomer-service-rest", url = "localhost:8000")
@FeignClient(name = "cutomer-service-rest")
public interface CustomerServiceRestProxy {

	@GetMapping("/customers")
	public List<Customer> retriveAllCustomers ();
	
	@GetMapping("/customers/{theId}")
	public Customer retriveCustomerById(@PathVariable Integer theId);
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer (@Validated @RequestBody Customer theCustomer);
	

	@DeleteMapping("/customers/{theId}")
	public void deleteCustomer(@PathVariable Integer theId);
	
	@PutMapping("/customers/{theId}")
	public void updateCustomer(@PathVariable Integer theId , @RequestBody Customer theCustomer);
	
}
