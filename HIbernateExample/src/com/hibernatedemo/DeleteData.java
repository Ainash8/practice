package com.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.annotation.Student;

public class DeleteData {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		SessionFactory sf = new Configuration()
							.configure("resources/hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		try {
			int studentId = 2;
			System.out.println("begin....");

			session.beginTransaction();
			System.out.println("Getting Student with Id" +studentId);
			
			Student st = session.get(Student.class,studentId);
			System.out.println("Deleting student");
			
			session.delete(st);
			
			session.getTransaction().commit();
			
			session = sf.getCurrentSession();
			session.beginTransaction();
	
			List<Student> studentlist = session.createQuery("from Student").getResultList();
		
			for(Student s : studentlist)
			{
				System.out.println(s);
			}
			
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			sf.close();
		}

	}

}
