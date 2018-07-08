package com.tcs.sachin.notfounderror;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ServiceImpl {

	public static void main(String[] args) {
		
		UserDetails user2 = new UserDetails();
		user2.setName("sachin");

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Yamaha-FZ-25");
		vehicle1.setUser(user2);
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Honda CB Unicorn");
//		vehicle2.setUser(user2);

		
		Configuration config = new Configuration();
		SessionFactory sessionfactory = config.configure("/com/tcs/sachin/notfounderror/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(user2);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
		
		
		session = sessionfactory.openSession();
		Vehicle getVehicle = session.get(Vehicle.class, 3);
		System.out.println("Vehicle:"+getVehicle.getVehicleName());
		System.out.println("User: "+getVehicle.getUser().getName());
		session.close();
		

	}

}
