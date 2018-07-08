package com.tcs.sachin.entities;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="user_details")
public class UserDetails {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userid")
	private int id;
	
	@Column(name="username")
	@Transient                 // excluding field from being added as column in table
	private String name;
	
	@Column(name="join_date")
	@Temporal(TemporalType.DATE)  // only date should be saved
	private Date joinDate;
	
	@Embedded
	private UserAddress address;
	
	@Lob
	private String description;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="office_street_name")),
		@AttributeOverride(name="city", column=@Column(name="office_city_name")),
		@AttributeOverride(name="pincode", column=@Column(name="office_pincode_name"))
	})
	private UserAddress officeAddress;
	
/*	@Embedded
	private List<UserAddress> addressList;*/
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userid")             ----        Annotation @ method level*/
	public int getId() {
		return id;
	}
	
//	@Column(name="username")             ----        Annotation @ method level
	public String getName() {
		return name ;	
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public UserAddress getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(UserAddress officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

/*	public List<UserAddress> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<UserAddress> addressList) {
		this.addressList = addressList;
	}*/
}
