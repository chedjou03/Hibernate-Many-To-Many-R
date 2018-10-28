package com.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;



public class CreateCoursesStudentsDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.addAnnotatedClass(Review.class)
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			//start transaction
			session.beginTransaction();
		
			//create and save instructor
			//Instructor theInstructor = new Instructor("Marck","Smith","MarclSmith@yahoo.fr");
			//Instructor theInstructor1 = new Instructor("Sun","Lin","SunLin@yahoo.fr");
			
			//create some course
			Course theCourse1 = new Course("Programing Java 1");
			Course theCourse2 = new Course("Programing C# 1");
			Course theCourse3 = new Course("Operating System Linux 1");
			Course theCourse4 = new Course("Algorithm Ananlysist 1");
			
			//add course to Instructor
			//theInstructor.addCourse(theCourse1);
			
			//save Instructors
			//session.save(theInstructor);
		//	session.save(theInstructor1);
			
			//save the Course
			session.save(theCourse1);
			session.save(theCourse2);
			session.save(theCourse3);
			session.save(theCourse4);
				
			
			
			
			//create Students
			Student theStudent = new Student("Florence","Kuissu","Florence@yahoo.com");
			Student theStudent1 = new Student("CLotild","Kengne","Clotilde@yahoo.com");
			Student theStudent2 = new Student("Janine","Nekame","NekJaninne@yahoo.com");
			Student theStudent3 = new Student("Jean Pierre","Fossi","Fossi@yahoo.com");
			
			//add students to student
			theCourse1.addStudent(theStudent3);
			theCourse1.addStudent(theStudent2);
			theCourse1.addStudent(theStudent1);
			theCourse1.addStudent(theStudent);
			
			//save the student
			session.save(theStudent);
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theStudent3);
							
						
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
