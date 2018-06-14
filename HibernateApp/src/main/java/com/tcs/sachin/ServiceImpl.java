package com.tcs.sachin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tcs.sachin.entities.UserAddress;
import com.tcs.sachin.entities.UserDetails;

public class ServiceImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*UserDetails user = new UserDetails();
		user.setName("wakle");*/
		UserAddress address = new UserAddress("bhumkar road","pune",411057);
		UserAddress address2 = new UserAddress("nagar road","pune",411006);
		List<UserAddress> addressList = new ArrayList<UserAddress>();
		addressList.add(address);
		addressList.add(address2);
		
		UserDetails user2 = new UserDetails();
		user2.setName("sachin");
		user2.setJoinDate(new Date());
		user2.setAddress(address);
		user2.setOfficeAddress(address2);
		
		Configuration config = new Configuration();
		SessionFactory sessionfactory = config.configure("/com/tcs/sachin/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionfactory.openSession();
		session.beginTransaction();
//		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		/*session = sessionfactory.openSession();
		UserDetails userFromDB = session.get(UserDetails.class, 1);
		System.out.println("_________________________________");
		System.out.println("Id: "+userFromDB.getId()+", UserName: "+userFromDB.getName());*/

	}

}
