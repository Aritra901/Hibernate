package com.aritra.Practice_.Hibernate.CRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;


public class Main {

	public static void main(String[] args) {
		Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory factory = con.buildSessionFactory(reg); 
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from UserDetails");
		List<UserDetails> user = (List<UserDetails>)query.list();
		for(UserDetails u : user) {
			System.out.println("The user is" + u);
		}
//		for(int i=1; i<=10; i++) {
//			UserDetails user = new UserDetails();
//			user.setUser_Name("User " + i);
//			session.save(user);
//		}
		tx.commit();
	}

}
