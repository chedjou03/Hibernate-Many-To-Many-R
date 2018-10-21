package com.hibernate.demo.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;



public class DeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			int theId = 2;
			
			//start transaction
			session.beginTransaction();
		
			//get the Instructor to be deleted
			Instructor tempInstructor = session.get(Instructor.class, theId);
					
			//delete  the instructor
			if(tempInstructor != null)
			{
				System.out.println("Instructor Found  "+tempInstructor);
				session.delete(tempInstructor);
			}
			else
			{
				System.out.println("not instructor with ID "+theId);
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
