package org.example.springhibernate.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class StudentDeleteDemoApp {

    public static void main(String[] args) {
        try (
            SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()
        ) {
            testDeleteByEntity(sessionFactory);

            testDeleteByHql(sessionFactory);
        }
    }

    private static void testDeleteByHql(SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        long studentIdToDelete = 3;
        int nums = session.createMutationQuery("delete Student where id = :id")
            .setParameter("id", studentIdToDelete)
            .executeUpdate();

        if (nums > 0) {
            System.out.println("删除 id 为 " + studentIdToDelete + " 的学生");
        } else {
            System.out.println("未找到 id 为 " + studentIdToDelete + " 的学生");
        }

        transaction.commit();
    }

    private static void testDeleteByEntity(SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        long studentIdToDelete = 1;
        Optional.ofNullable(session.get(Student.class, studentIdToDelete))
            .ifPresentOrElse(
                student -> {
                    session.remove(student);
                    System.out.println("删除 id 为 " + studentIdToDelete + " 的学生");
                },
                () -> System.out.println("未找到 id 为 " + studentIdToDelete + " 的学生")
            );

        transaction.commit();
    }
}
