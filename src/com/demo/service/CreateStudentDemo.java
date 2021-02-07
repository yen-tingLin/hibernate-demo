package com.demo.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();				
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		// use the session object to save Java object
		try {
			// create a student object
			Student newStudent = new Student("Mimi", "lyn", "mimi@gmail.com");
			System.out.println("new student created");
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(newStudent);
			System.out.println("new student saved");
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("committed");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			sessionFactory.close();
		}

	}

}
