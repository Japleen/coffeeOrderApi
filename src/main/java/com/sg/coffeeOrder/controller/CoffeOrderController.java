package com.sg.coffeeOrder.controller;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sg.coffeeOrder.model.StaffRegister;
import com.sg.coffeeOrder.service.CoffeeOrderService;


@CrossOrigin
@RestController
@RequestMapping("/coffee")
public class CoffeOrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeOrderController.class);
    
	@Autowired
	CoffeeOrderService coffeeOrderService;
	
	@PostMapping("/")
	public String home() {
		return "index.html";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public void login(@RequestHeader(value = "Authorization") String authorization) {

		try {
			byte[] base64decodedBytes = Base64.getDecoder().decode(authorization.split(" ")[1]);
			String decoded = new String(base64decodedBytes);
			String user = decoded.split(":")[0];
			String password = decoded.split(":")[1];
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.debug(e.getMessage());
		}
		
	//	ResponseEntity.status(200);
	}
	
	@RequestMapping(value="/createUser" , method= RequestMethod.POST)
	public void createUser(@RequestBody StaffRegister staff) {
		try {
			if(staff!=null) {
				coffeeOrderService.createUser(staff);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			}
	}

	
}
