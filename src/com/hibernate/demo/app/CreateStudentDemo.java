package com.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			//create a new student object
			Student theStudent = new Student ("Christiano","Ronaldo","ronaldo@yahoo.fr");
			Student theStudent1 = new Student ("Steph","Curry","Curry@yahoo.fr");
			Student theStudent2 = new Student ("Kevin","Durant","KD@yahoo.fr");
			
			//start transaction
			session.beginTransaction();
			
			//save the student
			session.save(theStudent);
			session.save(theStudent1);
			session.save(theStudent2);
			
			
			//commit the transaction
			session.getTransaction().commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}

	}

}
