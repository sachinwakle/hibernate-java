package com.tcs.sachin.collections.proxyobject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ServiceImpl {

	public static void main(String[] args) {
		
		UserAddress address = new UserAddress("bhumkar road","pune",411057);
		UserAddress address2 = new UserAddress("nagar road","pune",411006);
		
		UserDetails user2 = new UserDetails();
		user2.setName("sachin");
		user2.getAddressList().add(address2);
		user2.getAddressList().add(address);
		
		Configuration config = new Configuration();
		SessionFactory sessionfactory = config.configure("/com/tcs/sachin/collections/proxyobject/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		user2 = null;
		session = sessionfactory.openSession();
		user2 = session.get(UserDetails.class, 1);
		session.close();
		System.out.println("Address List size: "+user2.getAddressList().size());     // @ElementCollection(fetch=FetchType.EAGER)

	}

}
