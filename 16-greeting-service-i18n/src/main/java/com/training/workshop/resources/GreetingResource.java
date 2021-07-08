package com.training.workshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingResource {
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping("/greetings")
	public String helloWorld(
				//@RequestHeader(name = "Accept-Language",required = false) Locale locale
			) {
		//return "Hello World";
//		return messageSource.getMessage("good.morning.message",null,"Gap INC (default)",locale);
		return messageSource.getMessage("good.morning.message",null,"Gap INC (default)",LocaleContextHolder.getLocale());
	}
}
