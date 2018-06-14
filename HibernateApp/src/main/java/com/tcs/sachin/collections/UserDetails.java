package com.tcs.sachin.collections;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
	@JoinTable(name="USER_ADDRESS",
	joinColumns=@JoinColumn(name="user_id")
	)
	@GenericGenerator(name="inc-gen",strategy="increment")
	@CollectionId(columns={@Column(name="address_id")}, generator = "inc-gen", type = @Type(type="long"))
	private Collection<UserAddress> addressList = new ArrayList<UserAddress>();

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

	public Collection<UserAddress> getAddressList() {
		return addressList;
	}

	public void setAddressList(Collection<UserAddress> addressList) {
		this.addressList = addressList;
	}

	

}
