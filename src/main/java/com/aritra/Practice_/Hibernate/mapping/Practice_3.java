package com.aritra.Practice_.Hibernate.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

//import com.aritra.practice.hibernate.Alien;

public class Practice_3 {

	public static void main(String[] args) {
		Laptop lap = new Laptop();
		lap.setLid(1);
		lap.setLname("hp");
		Student std = new Student();
		std.setSname("Aritra");
		std.setSid(1);
		std.getLap().add(lap);
		lap.getStd().add(std);
      Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
      ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
      SessionFactory sf = con.buildSessionFactory(reg);
      Session session = sf.openSession();
      Transaction tx = session.beginTransaction();
      session.save(lap);
      session.save(std);
      Student st = session.get(Student.class, 1);
      tx.commit();
      System.out.println(st);
      
	}

}
