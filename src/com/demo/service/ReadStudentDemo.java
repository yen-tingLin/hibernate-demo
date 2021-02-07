package com.demo.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
	
		
		// retrieve object with session
		try {
			// create session
			Session session = sessionFactory.getCurrentSession();							
			// start a transaction
			session.beginTransaction();
			
			// retrieve object with session
			Student student = session.get(Student.class, 3);
			if(student != null) {
				System.out.println("student retrieved : " + student);
			}	
			
			// commit retrieve
			session.getTransaction().commit();
			System.out.println("retrieve committed");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			sessionFactory.close();
		}

	}

}
