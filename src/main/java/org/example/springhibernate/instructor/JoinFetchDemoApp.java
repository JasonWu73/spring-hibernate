package org.example.springhibernate.instructor;

import cn.hutool.core.lang.Console;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class JoinFetchDemoApp {

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
                long instructorId = 1;
                Instructor instructor = session.createQuery(
                        "select i from Instructor i join fetch i.courses where i.id = :id",
                        Instructor.class
                    )
                    .setParameter("id", instructorId)
                    .getSingleResult();
                Console.log("获取 id 为 {} 的讲师基础数据: {}", instructorId, instructor);
                Console.log("获取 id 为 {} 的讲师详细数据: {}", instructorId, instructor.getInstructorDetail());

                // 获取讲师的课程
                Console.log("id 为 {} 的讲师课程: {}", instructorId, instructor.getCourses());

                // 正常流程, 提交事务
                transaction.commit();
            } catch (Exception e) {
                // 异常流程, 回滚事务
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException(e);
            }
        }
    }
}
