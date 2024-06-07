package com.aritra.Practice_.Hibernate.CRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


public class Main {

	public static void main(String[] args) {
		Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory factory = con.buildSessionFactory(reg); 
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
////		try {
////		System.out.println(session.get(UserDetails.class,3));
//////		session.delete(session.get(UserDetails.class, 1));
////		UserDetails user = session.get(UserDetails.class, 3);
////		user.setUser_name("Aritra Ghosh " );
////		session.update(user);
////		} catch (Exception e) {
////			// TODO: handle exception
////			System.out.println("Object not found...");
////		}
//		for(int i=1; i<=10 ; i++) {
//		UserDetails user = new UserDetails();
//		user.setUser_name("User_" + i);
//		session.save(user);
//		}
		
		
		// Criteria API...
		CriteriaBuilder Cq = session.getCriteriaBuilder();
		CriteriaQuery<UserDetails> query = Cq.createQuery(UserDetails.class);
		Root<UserDetails> root = query.from(UserDetails.class);
		Predicate predicate = Cq.equal(root.get("User_name"), "User_10");
		
		tx.commit();
	}

}
