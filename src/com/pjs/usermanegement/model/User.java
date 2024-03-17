package com.pjs.usermanegement.model;

public class User {
	private String name;
	private String address;
	private String phone_number;
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public User(String name, String address, String phone_number2, String gender) {
		super();
		this.name = name;
		this.address = address;
		this.phone_number = phone_number2;
		this.gender = gender;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "[name=" + name + ", address=" + address + ", phone_number=" + phone_number + ", gender=" + gender
				+ "]";
	}
	
	

}
