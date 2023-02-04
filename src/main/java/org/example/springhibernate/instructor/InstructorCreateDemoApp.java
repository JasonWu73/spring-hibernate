package org.example.springhibernate.instructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InstructorCreateDemoApp {

    public static void main(String[] args) {
        try (
            SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()
        ) {
            Session session = sessionFactory.getCurrentSession();
            Transaction transaction = session.beginTransaction();

            try {
                Instructor instructor = new Instructor("Bruce", "Lee", "brucelee@gmail.com");
                InstructorDetail instructorDetail = new InstructorDetail(
                    "https://www.youtube.com/@brucelee",
                    "Kongfu"
                );
                instructor.setInstructorDetail(instructorDetail);

                session.persist(instructor);

                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw new RuntimeException(e);
            }
        }
    }
}
