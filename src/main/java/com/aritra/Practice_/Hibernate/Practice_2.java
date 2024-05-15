package com.aritra.Practice_.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Practice_2 {
	public static void main(String[] args) {
		AlienName an = new AlienName();
		an.setFname("Sandipan");
		an.setMname("Kumar");
		an.setLname("Majhi");
		Alien aritra = new Alien();
		aritra.setAid(1);
		aritra.setAname(an);
		aritra.setColor("Green");
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(aritra);
		
		tx.commit();
		session.close();
	}
}
