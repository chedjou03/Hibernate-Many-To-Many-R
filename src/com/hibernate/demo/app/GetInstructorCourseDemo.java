package com.hibernate.demo.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;



public class GetInstructorCourseDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			//start transaction
			session.beginTransaction();
		
			//get instructor from the DB
			int theInstructorID = 2;
			Instructor theInstructor = session.get(Instructor.class, theInstructorID);
			System.out.println(theInstructor);
			
			System.out.println(theInstructor.getCources());
			
			
			
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
