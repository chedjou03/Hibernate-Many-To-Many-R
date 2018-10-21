package com.hibernate.demo.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;



public class CreateDemo2 {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
		
			int theInstructorDetailId = 3;
			
			//start transaction
			session.beginTransaction();
		
			//get the Instructor detail 
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theInstructorDetailId);
					
			//delete  the instructor detail
			if(tempInstructorDetail != null)
			{
				System.out.println("Instructor Detail Found  "+tempInstructorDetail);
				System.out.println("******* ");
				System.out.println("Instructor Found  "+tempInstructorDetail.getInstructor());
				
			}
			else
			{
				System.out.println("not instructor Detail with ID "+theInstructorDetailId);
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
