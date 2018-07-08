package com.tcs.sachin.onetomany;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserAddress {
	
	
	@Column(name="street_name")
	private String street;
	
	@Column(name="city_name")
	private String city;
	
	@Column(name="pin_code")
	private int pincode;
	
	public UserAddress() {
	}
	
	public UserAddress(String street, String city, int pincode) {
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}
	
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
