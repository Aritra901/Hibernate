package com.aritra.Practice_.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien aritra = new Alien();
        aritra.setAid(109);
        aritra.setAname("Aritra");
        aritra.setColor("Black");
        Configuration con = new Configuration();
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        session.save(aritra);
        
        
    }
}
