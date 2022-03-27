package com.toby.saveJdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toby.model.Course;
import com.toby.model.Instructor;
import com.toby.model.InstructorDetail;
import com.toby.model.Review;
import com.toby.model.Student;

public class JdbcSave {

	public static void main(String args[]) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = null;

		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student student1 = new Student ("Tommy","Kwo","abc@gmail.com");
			Course course1 = new Course("Your mum");
			Course course2 = new Course("You dad");
			student1.addCourse(course1);
			student1.addCourse(course2);
			session.persist(student1);
			session.getTransaction().commit();
			session.close();

		}finally {
			factory.close();
		}
	}

}
