package com.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.annotation.Student;

public class Updatedata {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		SessionFactory sf = new Configuration()
							.configure("resources/hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		try {
			int studentId = 3;
			System.out.println("begin....");

			session.beginTransaction();
			System.out.println("Getting Student with Id" +studentId);
			
			Student st = session.get(Student.class,studentId);
			System.out.println("Updating student");
			
			st.setLastName("XXXCCCC");

			System.out.println(st);
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			sf.close();
		}

	}

}
