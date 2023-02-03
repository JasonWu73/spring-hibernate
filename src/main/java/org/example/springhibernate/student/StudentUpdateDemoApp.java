package org.example.springhibernate.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class StudentUpdateDemoApp {

    public static void main(String[] args) {
        try (
            SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()
        ) {
            testUpdateStudentFirstName(sessionFactory);

            testUpdateEmailForAllStudents(sessionFactory);
        }
    }

    private static void testUpdateEmailForAllStudents(SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();

        session.createMutationQuery("update Student set email = 'foo@gmail.com'")
            .executeUpdate();

        transaction.commit();
    }

    private static void testUpdateStudentFirstName(SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();

        Student student = getStudentById(session, 1)
            .orElseThrow(() -> new RuntimeException("学生不存在"));

        student.setFirstName("政");

        transaction.commit();
    }

    private static Optional<Student> getStudentById(Session session, long id) {
        return Optional.ofNullable(session.get(Student.class, id));
    }
}
