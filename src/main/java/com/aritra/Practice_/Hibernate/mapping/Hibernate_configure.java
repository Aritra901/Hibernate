package com.aritra.Practice_.Hibernate.mapping;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.aritra.practice.hibernate.Alien;

public class Hibernate_configure {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Create a StandardServiceRegistry
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() 
                    .build();

            // Create MetadataSources
            MetadataSources sources = new MetadataSources(registry);

            // Add annotated classes
            sources.addAnnotatedClass(Alien.class);
            sources.addAnnotatedClass(Laptop.class);
            // Add more annotated classes as needed

            // Create Metadata and SessionFactory
            sessionFactory = sources.buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // Handle exception if any
            e.printStackTrace();
//            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
