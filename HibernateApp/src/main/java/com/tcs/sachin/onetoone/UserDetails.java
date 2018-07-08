package com.tcs.sachin.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	@OneToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle userVehicle;

	public Vehicle getUserVehicle() {
		return userVehicle;
	}

	public void setUserVehicle(Vehicle userVehicle) {
		this.userVehicle = userVehicle;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
