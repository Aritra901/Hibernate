package com.aritra.Practice_.Hibernate.Practice.practiceHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;
@Transactional
public class practice_Crud {

    public static void main(String[] args) {
        
        // Create an instance of Institution
        Institution insti = new Institution();
        insti.setInsti_id(101);
        insti.setInsti_name("Institute_1");

        // Create instances of Class
        Class class_1 = new Class();
        class_1.setClass_id(1);
        class_1.setClass_name("Class_1");
        
        Class class_2 = new Class();
        class_2.setClass_id(2);
        class_2.setClass_name("Class_2");

        // Add Institution to Classes
        class_1.getInstitute().add(insti);
        class_2.getInstitute().add(insti);

        // Add Classes to Institution
        insti.getClasses().add(class_1);
        insti.getClasses().add(class_2);

        // Create instances of Section
        Section sec_A = new Section();
        sec_A.setSection_id(201);
        sec_A.setSection_name("Section_A");
        
        Section sec_B = new Section();
        sec_B.setSection_id(202);
        sec_B.setSection_name("Section_B");
        
        Section sec_C = new Section();
        sec_C.setSection_id(203);
        sec_C.setSection_name("Section_C");

        // Add Sections to Classes
        class_1.getDepartment().add(sec_A);
        class_1.getDepartment().add(sec_B);
        
        class_2.getDepartment().add(sec_A);
        class_2.getDepartment().add(sec_C);

        // Add Classes to Sections
        sec_A.getClass_in().add(class_1);
        sec_B.getClass_in().add(class_1);
        
        sec_A.getClass_in().add(class_2);
        sec_C.getClass_in().add(class_2);

        // Create instances of Student
        Student std_1 = new Student();
        std_1.setStd_id(1);
        std_1.setStd_name("Aritra Ghosh");
        std_1.setStd_age(23);
        
        Student std_2 = new Student();
        std_2.setStd_id(2);
        std_2.setStd_name("Sandipan Majhi");
        std_2.setStd_age(22);
        
        Student std_3 = new Student();
        std_3.setStd_id(3);
        std_3.setStd_name("Subhayan Paul");
        std_3.setStd_age(23);
        
        Student std_4 = new Student();
        std_4.setStd_id(4);
        std_4.setStd_name("Soumyadip Paul");
        std_4.setStd_age(24);
        
        Student std_5 = new Student();
        std_5.setStd_id(5);
        std_5.setStd_name("Avijit Dutta");
        std_5.setStd_age(24);
        
        // Add Students to section....
        sec_A.getStudents().add(std_1);
        sec_A.getStudents().add(std_4);
        sec_B.getStudents().add(std_2);
        sec_B.getStudents().add(std_3);
        sec_C.getStudents().add(std_5);
        
//        std_1.setSec(sec_A);
//        std_2.setSec(sec_A);
        // Configure Hibernate and build SessionFactory
        Configuration con = new Configuration().configure().addAnnotatedClass(Institution.class)
                                .addAnnotatedClass(Class.class)
                                .addAnnotatedClass(Section.class)
                                .addAnnotatedClass(Student.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(reg);
        
        // Note: Further code for session management (e.g., saving entities to the database) can be added here.
        
        Session session = sf.openSession();

        org.hibernate.Transaction tx = session.beginTransaction();

        
//        session.save(insti);
//        session.save(class_1);
//        session.save(class_2);
//        session.save(sec_A);
//        session.save(sec_B);
//        session.save(sec_C);
//        session.save(std_1);
//        session.save(std_2);
//        session.save(std_3);
//        session.save(std_4);
//        session.save(std_5);
        Student std = session.get(Student.class, 1);
        System.out.println(std);
        std.setSec(sec_C);
        session.update(std);
        
        Class cls = session.get(Class.class, 1);
        session.delete(cls);
        
        tx.commit();
        session.close();
        sf.close();
        reg.close();
    }
}
