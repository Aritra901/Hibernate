package com.aritra.Practice_.Hibernate.Inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Main {

	public static void main(String[] args) {
		Worker wr = new Worker();
		wr.setWname("Employee..");
		ContractWorker con_wr = new ContractWorker();
		con_wr.setWname("Aritra");
		con_wr.setWsalary_Contract(120000);
		RegularWorker reg_wr = new RegularWorker();
		reg_wr.setWname("Sandipan");
		reg_wr.setWsalary_Regular(150000);

		Configuration con = new Configuration().configure().addAnnotatedClass(Worker.class)
				.addAnnotatedClass(RegularWorker.class).addAnnotatedClass(ContractWorker.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory factory = con.buildSessionFactory(reg); 
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(wr);
		session.save(reg_wr);
		session.save(con_wr);
		
		
		tx.commit();
	}

}
