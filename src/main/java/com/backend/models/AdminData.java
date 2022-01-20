package com.backend.models;

public class AdminData {
	int id;
	String name;
	String email;
	String password;
	
	public AdminData() {}
	
	public AdminData(int id, String name, String email, String pass) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = pass;
	}
	
	public int getID() { return id; }
	public String getName() { return name; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }
	
	public void setID(int id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setEmail(String email) { this.email = email; }
	public void setPassword(String pass) { this.password = pass; }
}
