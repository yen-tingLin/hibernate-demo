package com.demo.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create sessionFactory
		SessionFactory sessionFactory = new Configuration()
										.configure()
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();		
		// delete student with session
		try {
			// create session
			Session session = sessionFactory.getCurrentSession();
			// begin transaction
			session.beginTransaction();
			
			// delete particular student with id
			Student student = session.get(Student.class, 3);			
			if(student != null) {
				session.delete(student);
			}		
			// delete students with where clause
			String sql = "delete Student s where s.email like 'non%'";
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
