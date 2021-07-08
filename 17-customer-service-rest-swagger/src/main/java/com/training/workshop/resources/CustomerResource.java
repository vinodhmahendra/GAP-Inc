package com.training.workshop.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.training.workshop.exceptions.CustomerNotFoundException;
import com.training.workshop.model.Customer;
import com.training.workshop.services.CustomerService;

@RestController
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> retriveAllCustomers (){
		return customerService.retrieveAllCustomers(); 
	}
	
	
	//http://localhost:8080/customers/1 , http://localhost:8080/customers/2 ...
	@GetMapping("/customers/{theId}")
	public Customer retriveCustomerById(@PathVariable Integer theId) {
		Customer thecustomer =  customerService.retrieveCustomerById(theId);
		if (thecustomer == null) {
			throw new CustomerNotFoundException("id - " + theId);
		}
		return thecustomer;
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer (@Valid @RequestBody Customer theCustomer){
		
		Customer savedCustomer = customerService.createCustomer(theCustomer);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{theId}")
				.buildAndExpand(savedCustomer.getId())
				.toUri();
		
		return  ResponseEntity.created(location).build();
	}

	@DeleteMapping("/customers/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable Integer theId) {
		customerService.removeCustomerById(theId);
	}
	
	
	@PutMapping("/customers/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCustomer(@PathVariable Integer theId , @RequestBody Customer theCustomer) {
		
		Customer savedCustomer = customerService.retrieveCustomerById(theId);
		
		savedCustomer.setId(theId);
		savedCustomer.setFirstName(theCustomer.getFirstName());
		savedCustomer.setLastName(theCustomer.getLastName());
		savedCustomer.setEmail(theCustomer.getEmail());
		
	}
	
}
