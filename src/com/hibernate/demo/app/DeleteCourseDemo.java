package com.hibernate.demo.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;



public class DeleteCourseDemo {

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
		
			//get course to be deleted from the DB
			int theCourseId = 10;
			Course theCourse  = session.get(Course.class, theCourseId);
					
			//delete the course
			if(theCourse != null)
			{
				session.delete(theCourse);
			}
			else 
			{
				System.out.println("No Course with ID "+theCourseId);
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
