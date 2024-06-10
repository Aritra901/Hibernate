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
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


public class Main {

	public static void main(String[] args) {
		Configuration con = new Configuration().configure().addAnnotatedClass(UserDetails.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory factory = con.buildSessionFactory(reg); 
		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
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
		/*
		 * 
		 *part 1
//		Predicate predicate = Cq.equal(root.get("User_name"), "User_10"); We create a restriction from criteria builder object..
//		query.select(root);
//		query.where(predicate);//the restriction we created goes into where clause.
		//Writing the same Above thing in one Line...
		query.select(root).where(Cq.equal(root.get("User_name"),"User_5"));
		*/
		/*part 2
		 * Selecting users with id greater then 5..
		query.select(root).where(Cq.gt(root.get("User_id"), 5));
		*/
		/*
		 * Selecting users with id less than 5
		 
		query.select(root).where(Cq.lt(root.get("User_id"), 5));
		*/
		/* part 3 
		 * Selecting users that are that have first 4 ch. their name as "User" , basically i will get all the entities ..

		query.select(root).where(Cq.like(root.get("User_name"), "User%"));
		*/
		/* part 4
		 * Selecting users who were having id between 2 and 6..
		 * 
		query.select(root).where(Cq.between(root.get("User_id"), 2 , 6));
		*/
		/* part 5
		 * Selecting users with more than one user names randomly..
		 
		query.select(root).where(root.get("User_name").in("User_2", "User_5", "User_9"));
		*/
		/* part 6
		 * 
		 * using two restriction with OR operator
			Predicate greaterThan = Cq.gt(root.get("User_id"), 5);
			Predicate likewise = Cq.like(root.get("User_name"), "User%");
			query.select(root).where(Cq.and(greaterThan,likewise));
		*/
//		query.orderBy(Cq.asc(root.get("User_name")),Cq.desc(root.get("User_id")));
		/* part 7 
		 * Update entities with the help of criteria query..
		
		CriteriaUpdate<UserDetails> criteriaUpdate = Cq.createCriteriaUpdate(UserDetails.class);
		Root<UserDetails> rootUpdate = criteriaUpdate.from(UserDetails.class);
		criteriaUpdate.set("User_name", "Aritra Ghosh");
		criteriaUpdate.where(Cq.equal(rootUpdate.get("User_id"), 10));
		Transaction tx1 =  session.beginTransaction();
		session.createQuery(criteriaUpdate).executeUpdate();
		tx1.commit();
		*/
		/* part 8
		 * Delete operation using criteria query
		
		CriteriaDelete<UserDetails> criteriaDelete = Cq.createCriteriaDelete(UserDetails.class);
		Root<UserDetails> rootDelete = criteriaDelete.from(UserDetails.class);
		criteriaDelete.where(Cq.equal(rootDelete.get("User_id"), 10));
		Transaction tx1 =  session.beginTransaction();
		session.createQuery(criteriaDelete).executeUpdate();
		tx1.commit();
		*/
		
		Transaction tx = session.beginTransaction();
		query.select(root);
		Query<UserDetails> qr = session.createQuery(query);
		List<UserDetails> results = qr.getResultList();
		for(UserDetails user : results) System.out.println(user);
		tx.commit();
	}

}
