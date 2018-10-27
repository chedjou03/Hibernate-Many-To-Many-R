package com.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;



public class CreateCourseReviewsDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.addAnnotatedClass(Review.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			//start transaction
			session.beginTransaction();
		
			//create and save instructor
			Instructor theInstructor = new Instructor("Marck","Smith","MarclSmith@yahoo.fr");
			Instructor theInstructor1 = new Instructor("Sun","Lin","SunLin@yahoo.fr");
			session.save(theInstructor);
			session.save(theInstructor1);
			
			//get instructor from the DB
			int theInstructorID = 2;
			Instructor tempInstructor = session.get(Instructor.class, theInstructorID);

			
			//create some course
			Course theCourse1 = new Course("Programing Java");
			Course theCourse2 = new Course("Programing C#");
			Course theCourse3 = new Course("Operating System Linux");
			Course theCourse4 = new Course("Algorithm Ananlysist");
			
			
			//create review and add review to course1
			Review theReview = new Review("Good course");
			Review theReview1 = new Review("Good course");
			Review theReview2 = new Review("I love this course nd the teacher");
			
			//add reviews to course
			theCourse1.addReview(theReview);
			theCourse1.addReview(theReview1);
			theCourse1.addReview(theReview2);
			
			
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
