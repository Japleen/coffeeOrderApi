package com.sg.coffeeOrder.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.sg.coffeeOrder.dao.CoffeOrderDao;

@ComponentScan("com.sg.CoffeeOrder.*")
@SpringBootApplication
public class CoffeeApplication {
	
	@Autowired
	private CoffeOrderDao coffeOrderDao;
	
	public static void main(String[] args) {
		SpringApplication.run(CoffeeApplication.class, args);
	
	}
}
