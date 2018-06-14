package com.tcs.sachin.appe;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ServiceImpl {

	public static void main(String[] args) {
		
		UserAddress address = new UserAddress("bhumkar road","pune",411057,1);
		UserAddress address2 = new UserAddress("nagar road","pune",411006,2);
		List<UserAddress> addressList = new ArrayList<UserAddress>();
		addressList.add(address);
		addressList.add(address2);
		
		UserDetails user2 = new UserDetails();
		user2.setName("sachin");
		user2.setAddressList(addressList);
		
		Configuration config = new Configuration();
		SessionFactory sessionfactory = config.configure("/com/tcs/sachin/appd/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(user2);
		session.getTransaction().commit();
		session.close();

	}

}
