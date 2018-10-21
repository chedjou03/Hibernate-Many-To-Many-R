package com.hibernate.demo.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;



public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			//create the objects
			Instructor theInstructor = new Instructor("Simplice","Chedjou","chedjou03@yahoo.fr");
			
			InstructorDetail theInstructorDetail = new InstructorDetail("http://youtube.com/chedjousimplice","soccer");
			
			//associate the objects
			theInstructor.setInstructorDetail(theInstructorDetail);
			
			//start transaction
			session.beginTransaction();
		
			//save  the instructor
			session.save(theInstructor);
			
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
