package com.sg.coffeeOrder.dao;

import org.springframework.stereotype.Component;

import com.sg.coffeeOrder.model.StaffRegister;

@Component
public interface CoffeeOrderDao {
	
	public void createUser(StaffRegister staff);
}
