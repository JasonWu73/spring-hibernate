package org.example.springhibernate.student;

import cn.hutool.core.lang.Console;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentQueryDemoApp {

    public static void main(String[] args) {
        try (
            SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()
        ) {
            Session session = sessionFactory.getCurrentSession();

            Transaction transaction = session.getTransaction();
            transaction.begin(); // Hibernate 要求必须开启事务才可执行

            testGetAllStudents(session);

            testGetStudentByLastName(session);

            testGetStudentByLastNameLike(session);

            testGetStudentsByLastNameOr(session);
        }
    }

    private static void testGetStudentsByLastNameOr(Session session) {
        String hql = "from Student s where s.lastName like 'w%' or s.lastName = '吴'";
        List<Student> students = session.createQuery(hql, Student.class).list();

        printForDebug(hql, students);
    }

    private static void testGetStudentByLastNameLike(Session session) {
        String hql = "from Student s where s.lastName like 'w%'";
        List<Student> students = session.createQuery(hql, Student.class).list();

        printForDebug(hql, students);
    }

    private static void testGetStudentByLastName(Session session) {
        String hql = "from Student s where s.lastName = '吴1'";
        List<Student> students = session.createQuery(hql, Student.class).list();

        printForDebug(hql, students);
    }

    private static void testGetAllStudents(Session session) {
        String hql = "from Student";
        List<Student> students = session.createQuery(hql, Student.class).list();

        printForDebug(hql, students);
    }

    private static void printForDebug(String fromStudentQueryString, List<?> resultList) {
        Console.log("HQL: {}", fromStudentQueryString);
        if (resultList.isEmpty()) {
            Console.log("None\n");
            return;
        }

        resultList.forEach(System.out::println);
        Console.log();
    }
}
