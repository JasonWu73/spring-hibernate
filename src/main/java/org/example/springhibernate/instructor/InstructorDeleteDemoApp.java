package org.example.springhibernate.instructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InstructorDeleteDemoApp {

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
                long instructorIdToDelete = 2;

                // HQL 不会触发级联操作
                /*
                session.createMutationQuery("delete Instructor where id = :id")
                    .setParameter("id", instructorIdToDelete)
                    .executeUpdate();
                */

                Instructor instructor = session.get(Instructor.class, instructorIdToDelete);
                if (instructor == null) throw new RuntimeException("未找到 id 为 " + instructorIdToDelete + " 的讲师");

                session.remove(instructor);

                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }
}
