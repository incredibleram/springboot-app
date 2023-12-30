package com.inm429.ecommerce.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;

	@Column(name = "email")
	String email;

	@Column(name = "name")
	String name;

	@Column(name = "mobile")
	int mobile;

	@Column(name = "address")
	String address;

	@Column(name = "pincode")
	int pincode;

	@Column(name = "password")
	String password;
	
	@Column(name="user_type")
	int userType;

	public User(int userId, String email, String name, int mobile, String address, int pincode, String password, int userType) {
		super();
		this.email = email;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.pincode = pincode;
		this.password = password;
		this.userType = userType;
		this.userId = userId;
	}

	public User() {
		super();
	}
	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
}
