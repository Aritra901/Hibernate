package com.aritra.Practice_.Hibernate.CRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

public class Practice_CRUD {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory factory = con.buildSessionFactory(registry);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
//		String UserId = " 5 or 1 = 1";//SQL injection example get all the records...
		int  UserId = 5;
		Query query = session.createQuery("select User_name from UserDetails where  User_id > :UserId ");
		query.setParameter("UserId",UserId);
//		query.setFirstResult(5);
//		query.setMaxResults(4);
		List<String> user = (List<String>)query.list();
//		System.out.println("Size of the userTable " + user.size());
		for(String u : user) {
			System.out.println(u);
		}
		
//		UserDetails user = 
//				(UserDetails)session.get(UserDetails.class, 6);
//		System.out.println("The name of the data is: " + user.getUser_name());
//		for(int i=0; i<10; i++) {
//			UserDetails user = new UserDetails();
//			user.setUser_name("User " + i);
//			session.save(user);
//		}
		tx.commit();
		session.close();
	}

}
