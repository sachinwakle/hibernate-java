package com.tcs.sachin.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ServiceImpl {

	public static void main(String[] args) {
		
		UserDetails user2 = new UserDetails();
		user2.setName("sachin");

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Yamaha-FZ-25");
		user2.setUserVehicle(vehicle1);
		
		
		Configuration config = new Configuration();
		SessionFactory sessionfactory = config.configure("/com/tcs/sachin/onetoone/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(user2);
		session.save(vehicle1);
		session.getTransaction().commit();
		session.close();

	}

}
