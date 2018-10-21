package com.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{

			int Id = 5;	
			
			//start transaction
			session.beginTransaction();
			
			
			//Use hibernate to get student for the given Id
			Student theStudent = session.get(Student.class, Id);
			
			if(theStudent != null)
			{
				session.delete(theStudent);
				
			}
			else
			{
				System.out.println("No Student with ID: "+Id);
			}
			
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
