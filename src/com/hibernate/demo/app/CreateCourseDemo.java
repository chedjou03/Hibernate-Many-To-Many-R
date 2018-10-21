package com.hibernate.demo.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;



public class CreateCourseDemo {

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

			
			//create some course
			Course theCourse1 = new Course("Programing 1");
			Course theCourse2 = new Course("Programing 2");
			Course theCourse3 = new Course("Operating System");
			Course theCourse4 = new Course("Algorithm");
			
			//add course to the instructor
			theInstructor.addCourse(theCourse1);
			theInstructor.addCourse(theCourse2);
			theInstructor.addCourse(theCourse3);
			theInstructor.addCourse(theCourse4);
			
			//save course
			session.save(theCourse1);
			session.save(theCourse2);
			session.save(theCourse3);
			session.save(theCourse4);
			
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
