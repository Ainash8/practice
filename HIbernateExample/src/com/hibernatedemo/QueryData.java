package com.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.annotation.Student;

public class QueryData {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		SessionFactory sf = new Configuration()
							.configure("resources/hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		try {
			System.out.println("begin....");
		
			session.beginTransaction();
	
			List<Student> studentlist = session.createQuery("from Student").getResultList();
		
			
			displayStudents(studentlist);
			
			studentlist = session.createQuery("from Student s where s.lastName = 'Yadav'").getResultList();
			
			System.out.println("Student record");
			
			displayStudents(studentlist);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally {
			sf.close();
		}

	}

	private static void displayStudents(List<Student> studentlist) {
		for(Student st : studentlist)
		{
			System.out.println(st);
		}
	}

}
