package com.training.workshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@GetMapping("/")
//	@PreAuthorize("ADMIN")
	public String helloSecurity() {
		return "Hello World! -Secured";
	}
}
