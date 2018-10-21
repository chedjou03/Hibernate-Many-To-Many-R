package com.hibernate.demo.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try
		{
			//create a new student object
			
			String theDateOfBirthStr = "03/07/1985";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
            
            Student theStudent = new Student("Paully", "Doe", "paul@luv.com", theDateOfBirth);
			
			//start transaction
			session.beginTransaction();
			
			//save the student
			session.save(theStudent);
			
			
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
