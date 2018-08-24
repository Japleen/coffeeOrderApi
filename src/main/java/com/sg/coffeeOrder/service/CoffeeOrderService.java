package com.sg.coffeeOrder.service;

import org.springframework.stereotype.Service;

import com.sg.coffeeOrder.model.StaffRegister;

@Service
public interface CoffeeOrderService {
	
	public void createUser(StaffRegister staff) ;
	public String generateHash(String password) ;
	
}
