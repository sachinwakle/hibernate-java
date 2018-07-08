package com.tcs.sachin.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ServiceImpl {

	public static void main(String[] args) {
		
		UserDetails user2 = new UserDetails();
		user2.setName("sachin");

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Yamaha-FZ-25");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Honda CB Unicorn");
		
		
		user2.getUserVehicle().add(vehicle1);
		user2.getUserVehicle().add(vehicle2);
		
		vehicle1.getUser().add(user2);
		vehicle2.getUser().add(user2);
		
		Configuration config = new Configuration();
		SessionFactory sessionfactory = config.configure("/com/tcs/sachin/manytomany/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(user2);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();

	}

}
