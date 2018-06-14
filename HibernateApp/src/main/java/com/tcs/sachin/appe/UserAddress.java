package com.tcs.sachin.appe;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserAddress {
	
	/*@Id
	@Column(name="address_id")
	private int id;*/
	
	@Column(name="street_name")
	private String street;
	
	@Column(name="city_name")
	private String city;
	
	@Column(name="pin_code")
	private int pincode;
	
	public UserAddress() {
	}
	
	public UserAddress(String street, String city, int pincode, int id) {
		this.street = street;
		this.city = city;
		this.pincode = pincode;
//		this.id = id;
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

/*	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

}
