package com.sg.coffeeOrder.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sg.coffeeOrder.model.StaffRegister;
import com.sg.coffeeOrder.service.CoffeeOrderService;
import com.sg.coffeeOrder.dao.CoffeeOrderDao; 

public class CoffeeOrderServiceImpl implements CoffeeOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeeOrderServiceImpl.class);

	public static final String SALT = "@!@%*@";
	
	@Autowired
	CoffeeOrderDao coffeeOrderDao;
	
	@Override
	public void createUser(StaffRegister staff) {
		// TODO Auto-generated method stub
		try {
			String saltedPassword = SALT + staff.getPassword();
			String hashedPassword = generateHash(saltedPassword);
			staff.setPassword(hashedPassword);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.debug(e.getMessage());
		}
		
		}
	
	public String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			LOGGER.debug(e.getMessage());
		}

		return hash.toString();
	}


}