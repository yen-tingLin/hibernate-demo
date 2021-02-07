package com.demo.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure()
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();		
		// update student with session
		try {
			// create session
			Session session = sessionFactory.getCurrentSession();
			// begin transaction
			session.beginTransaction();
			
			// update : particular student with id
			Student student = session.get(Student.class, 4);
			if(student != null) {
				student.setFirstName("Elmo");
			}		
			// update : multiple students with where clauses
			String sql = "update Student s set email='royal@gmail.com' where s.id=4 or s.id=6";
			session.createQuery(sql).executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			sessionFactory.close();
		}

	}

}
