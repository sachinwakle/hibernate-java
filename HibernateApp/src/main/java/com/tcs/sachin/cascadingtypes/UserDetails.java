package com.tcs.sachin.cascadingtypes;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	
	/**
	 *  No need to save every entity
	 *  which has included in another
	 *  entity (cascade=CascadeType.PERSIST)
	 *  And use persist() method for
	 *  saving object
	 */
	@ManyToMany(cascade=CascadeType.PERSIST)  
	@JoinTable(name="user_vehicle",
	joinColumns= {@JoinColumn(name="user_id")},
	inverseJoinColumns= {@JoinColumn(name="vehicle_id")})
	private Collection<Vehicle> userVehicle = new ArrayList<>();

	

	public Collection<Vehicle> getUserVehicle() {
		return userVehicle;
	}

	public void setUserVehicle(Collection<Vehicle> userVehicle) {
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
