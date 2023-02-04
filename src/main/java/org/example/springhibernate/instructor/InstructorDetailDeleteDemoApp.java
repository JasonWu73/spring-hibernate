package org.example.springhibernate.instructor;

import cn.hutool.core.lang.Console;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InstructorDetailDeleteDemoApp {

    public static void main(String[] args) {
        try (
            SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()
        ) {
            Session session = sessionFactory.getCurrentSession();
            Transaction transaction = session.beginTransaction();

            try {
                long instructorDetailId = 4;
                InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);
                Console.log("Get id of {} Instructor Detail: {}", instructorDetailId, instructorDetail);
                if (instructorDetail == null) {
                    throw new RuntimeException("Not Found Instructor of id " + instructorDetailId);
                }

                session.remove(instructorDetail);
                Console.log("Delete id of {} Instructor Detail", instructorDetailId);

                // Remove association from instructor
                instructorDetail.getInstructor().setInstructorDetail(null);

                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }
}
