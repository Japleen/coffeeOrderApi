package com.sg.coffeeOrder.model;

public class StaffLoginRequestModel {
	
	private String user;
	private String password;
	
	@Override
	public String toString() {
		return "StaffLoginRequestModel [user=" + user + ", password=" + password + "]";
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
