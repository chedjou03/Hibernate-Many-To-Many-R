package com.hibernate.demo.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;



public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			//create the objects
			Instructor theInstructor1 = new Instructor("William","Ngassa","Ngassa@yahoo.fr");		
			InstructorDetail theInstructorDetail1 = new InstructorDetail("http://youtube.com/WilliamNgassa","BasketBall");
			
			Instructor theInstructor2 = new Instructor("Simplice","Chedjou","Chedju03@yahoo.fr");		
			InstructorDetail theInstructorDetail2 = new InstructorDetail("http://youtube.com/SimpliceChedjou","HandBall");
			
			Instructor theInstructor3 = new Instructor("Chad","Tood","ChodTood@yahoo.fr");		
			InstructorDetail theInstructorDetail3 = new InstructorDetail("http://youtube.com/ChodTood","Tenis");
			
			//associate the objects
			theInstructor1.setInstructorDetail(theInstructorDetail1);
			theInstructor2.setInstructorDetail(theInstructorDetail2);
			theInstructor3.setInstructorDetail(theInstructorDetail3);
			
			//start transaction
			session.beginTransaction();
		
			//save  the instructor
			session.save(theInstructor1);
			session.save(theInstructor2);
			session.save(theInstructor3);
			
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
