package com.training.workshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class O8PropertyFileApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(O8PropertyFileApplication.class, args);
	}

	@Value("${message}")
	private String message;

	@GetMapping("/")
	public String greetings() {
		return message;
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("startup code goes here");
		
	}
}
