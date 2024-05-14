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
        Session session_2 = sf.openSession();
        Transaction tx = session.beginTransaction();
        Transaction tx2 = session_2.beginTransaction();
        
        		//        session.save(aritra); 
        Alien aritra2 = (Alien)session_2.get(Alien.class, 111);
        aritra = (Alien)session.get(Alien.class, 110);
        tx.commit();
        tx2.commit();
        System.out.println(aritra);
        System.out.println(aritra2);
    }
}
