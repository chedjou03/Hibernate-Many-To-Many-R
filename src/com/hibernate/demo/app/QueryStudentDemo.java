package com.hibernate.demo.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			//start transaction
			session.beginTransaction();
			
			//query all the student
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			
			DisplayResult(theStudents);
			
			
			//query one student
			theStudents = session.createQuery("from Student s where s.lastName ='chedjou'").getResultList();
			
			DisplayResult(theStudents);
				
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

	private static void DisplayResult(List<Student> theStudents) 
	{
		if(theStudents != null)
		{
			for(Student tempStudent : theStudents)
			{
				System.out.println(tempStudent);
			}
		}
		else
		{
			System.out.println("return null");
		}
		
		
	}

}
