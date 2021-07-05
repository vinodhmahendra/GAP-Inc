package com.training.workshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.training.workshop") 
@ComponentScan(basePackages = "com.training.workshop.repository,com.training.workshop.services") // optimised
public class MainConfig {
	
	

}
