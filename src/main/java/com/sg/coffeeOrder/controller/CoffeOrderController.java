package com.sg.coffeeOrder.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sg.coffeeOrder.model.StaffRegister;

@CrossOrigin
@RequestMapping("coffeeShop")
@RestController
public class CoffeOrderController {

	public static final String SALT = "@!@%*@";

	@PostMapping("/")
	public String home() {
		return "index.html";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public void login(@RequestHeader(value = "Authorization") String authorization) {

		byte[] base64decodedBytes = Base64.getDecoder().decode(authorization.split(" ")[1]);
		String decoded = new String(base64decodedBytes);
		String user = decoded.split(":")[0];
		String password = decoded.split(":")[1];


		String saltedPassword = SALT + password;
		String hashedPassword = generateHash(saltedPassword);

	//	ResponseEntity.status(200);
	}
	
	@RequestMapping(value="/createUser" , method= RequestMethod.POST)
	public void createUser(@RequestBody StaffRegister staff) {
	}

	public static String generateHash(String input) {
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
			// handle error here.
		}

		return hash.toString();
	}

}
