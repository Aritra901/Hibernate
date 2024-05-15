package com.aritra.Practice_.Hibernate;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class Practice_1 {
	public static void main(String[] args) {
		Alien aritra = new Alien();
      aritra.setAid(117);
//		aritra.setAname("Arijit");
//      aritra.setColor("");
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(aritra);
		tx.commit();
		ValidatorFactory vali =  Validation.buildDefaultValidatorFactory();
		Validator validator = (Validator) vali.getValidator();
		Set<ConstraintViolation<Alien>> violation = validator.validate(aritra);

		if (violation.isEmpty()) {
			System.out.println("Valid data providate");
		} else {
			for (ConstraintViolation<Alien> valid : violation) {
				System.out.println(valid.getMessage());
			}
		}
	}
}
