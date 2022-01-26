package com.backend.webproject.entity;

public class UserEntity {
	int id;
	String email;
	String password;
	String fullname;
	String address;
	String number;
	int role;
	
	public UserEntity() {
		this.address = "";
	}
	
	public UserEntity(int id, String email, String password, String fullname, String number, int role) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.address = "";
		this.number = number;
		this.role = role;	
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
	
	public String getEmail() {
		return email;
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
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getRole() {
		return role;
	}
	
	public void setRole(int role) {
		this.role = role;
	}
}
