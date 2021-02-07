package com.demo.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration()
										 .configure("hibernate.cfg.xml")
										 .addAnnotatedClass(Student.class)
										 .buildSessionFactory();
		// query student with session
		try {
			// create session
			Session session = sessionFactory.getCurrentSession();
			// begin transaction
			session.beginTransaction();
			
			// query with session : retrieve all
			String sql = "from Student s where s.firstName='Mimi'";
			List<Student> students = (List<Student>) session.createQuery("from Student").getResultList();
			students.stream().forEach(System.out::println);
			// query with session : retrieve mimi
			students = (List<Student>) session.createQuery(sql).getResultList();
			students.stream().forEach(System.out::println);		
			// query with session : retrieve mimi or mary
			sql = "from Student s where s.firstName='Mimi' or s.firstName='Mary'";
			students = session.createQuery(sql).getResultList();
			students.stream().forEach(System.out::println);			
			// query with session : retrieve LIKE 
			sql = "from Student s where s.email like '%gmail.com'";
			students = session.createQuery(sql).getResultList();
			students.stream().forEach(System.out::println);
			
			// query committed
			session.getTransaction().commit();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			sessionFactory.close();
		}

	}

}
