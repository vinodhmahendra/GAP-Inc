package com.training.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.workshop.model.Customer;
import com.training.workshop.proxy.CustomerServiceRestProxy;

@Controller
public class CustomerController {

	@Autowired
	private CustomerServiceRestProxy customerServiceRestProxy;

	@GetMapping(path = "/customers/list")
	public ModelAndView listOfCustomers() {
		
		List<Customer> customers = customerServiceRestProxy.retriveAllCustomers();

		ModelAndView model = new ModelAndView("list-customers");

		model.addObject("customers", customers);

		return model;
	}

	@GetMapping(path = "/customers/showFormForAdd")
	public ModelAndView showFormForAdd() {
		ModelAndView model = new ModelAndView("customer-form");

		Customer theCustomer = new Customer();

		model.addObject("customer", theCustomer);
		return model;
	}

	@PostMapping(path = "/customers/saveCustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		ModelAndView model = new ModelAndView("redirect:/customers/list");
		customerServiceRestProxy.createCustomer(theCustomer);
		return model;
	}

	@GetMapping(path = "/customers/showFormForUpdate")
	public ModelAndView showFormForUpdate(@RequestParam("customerId") Integer theId, Model theModel) {

		Customer theCustomer =  customerServiceRestProxy.retriveCustomerById(theId);

		theModel.addAttribute("customer", theCustomer);
		return new ModelAndView("customer-form");

	}

	@GetMapping(path = "/customers/delete")
	public ModelAndView deleteCustomerById(@RequestParam("customerId") Integer theId) {
		
		customerServiceRestProxy.deleteCustomer(theId);
		List<Customer> customers = customerServiceRestProxy.retriveAllCustomers();
		
		ModelAndView model = new ModelAndView("list-customers");
		model.addObject("customers", customers);
		
		return model;
		
	}

}
