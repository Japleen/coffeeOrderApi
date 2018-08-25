package com.sg.coffeeOrder.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sg.coffeeOrder.model.StaffRegister;

@Component
public interface CoffeeOrderService {
	
	public void createUser(StaffRegister staff) ;
	
	public String generateHash(String password) ;
	
}
