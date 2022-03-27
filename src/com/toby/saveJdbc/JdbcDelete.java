package com.toby.saveJdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toby.model.Course;
import com.toby.model.Instructor;
import com.toby.model.InstructorDetail;
import com.toby.model.Review;
import com.toby.model.Student;

public class JdbcDelete {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = null;
		
		try {
		/*	session = factory.getCurrentSession();
			session.beginTransaction();
			Course course = session.get(Course.class,"19");
			session.delete(course);
			session.getTransaction().commit();
			session.close();*/
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student student = session.get(Student.class,"10");
			session.delete(student);
			session.getTransaction().commit();
			session.close();
		}finally {
			factory.close();
		}

	}

}
