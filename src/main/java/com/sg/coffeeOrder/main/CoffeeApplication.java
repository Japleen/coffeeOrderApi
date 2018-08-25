package com.sg.coffeeOrder.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.sg.coffeeOrder.*")
@SpringBootApplication(scanBasePackages={
"com.sg.coffeeOrder.dao", "com.sg.coffeeOrder.rest", "com.sg.coffeeOrder.service"})
public class CoffeeApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(CoffeeApplication.class, args);
	
	}
}
