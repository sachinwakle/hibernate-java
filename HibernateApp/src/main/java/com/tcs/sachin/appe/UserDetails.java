package com.tcs.sachin.appe;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userid")
	private int id;
	
	@Column(name="username")
	private String name;
	
	@ElementCollection
	private List<UserAddress> addressList;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<UserAddress> getAddressList() {
		return addressList;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddressList(List<UserAddress> addressList) {
		this.addressList = addressList;
	}
	

}
