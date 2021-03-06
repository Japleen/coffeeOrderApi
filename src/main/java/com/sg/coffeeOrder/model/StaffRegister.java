package com.sg.coffeeOrder.model;

public class StaffRegister {
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	
	@Override
	public String toString() {
		return "StaffRegister [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + password + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
