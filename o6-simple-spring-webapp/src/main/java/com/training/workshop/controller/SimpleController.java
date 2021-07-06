package com.training.workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/showMessage.html")
public class SimpleController {
	

	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView helloWorld() {
		ModelAndView model = new ModelAndView();
		model.setViewName("showMessage"); // logical view name
		model.addObject("message" , " Spring  MVC Web Application With XML And Annotations"); // model
		
		return model ; // model + logical view name
		
	}


}
