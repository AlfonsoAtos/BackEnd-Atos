package com.backend.models;

public class UserData {
	int id;
	String username;
	String password;
	String fullname;
	String number;
	String address;
	
	public UserData() {
		this.address = "";
	}
	
	public UserData(int id, String username, String password, String fullname, String number) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.number = number;
		this.address = "";
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getFullname() {
		return fullname;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNumber() {
		return number;
	}

	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
