package org.example.springhibernate.instructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class CourseCreateDemoApp {

    public static void main(String[] args) {
        // 构建 Hibernate Session Factory
        try (
            SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()
        ) {
            // 获取 Hibernate Session
            Session session = sessionFactory.getCurrentSession();

            // 开启事务
            Transaction transaction = session.beginTransaction();

            try {
                // 获取讲师
                long theInstructorId = 1;
                Instructor instructor = Optional.ofNullable(session.get(Instructor.class, theInstructorId))
                    .orElseThrow(() -> new RuntimeException("未找到 id 为 " + theInstructorId + " 的讲师"));

                // 构建需要保存的课程, 设置课程与讲师的关联关系
                Course javaCourse = new Course("深入理解 JVM", instructor);
                Course jsCourse = new Course("JavaScript Async 函数", instructor);

                // 保存课程
                session.persist(javaCourse);
                session.persist(jsCourse);

                // 正常流程, 提交事务
                transaction.commit();
            } catch (Exception e) {
                // 异常流程, 回滚事务
                transaction.rollback();
                throw new RuntimeException(e);
            }
        }
    }
}