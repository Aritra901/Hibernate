package com.aritra.Practice_.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
        Alien aritra = null;
//        aritra.setAid(111);
//        aritra.setAname("Subhankar");
//        aritra.setColor("Blue");
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
//        session.save(aritra);
        aritra = (Alien)session.get(Alien.class, 110);
        tx.commit();
        System.out.println(aritra);
    }
}
