package org.example.springhibernate.instructor;

import cn.hutool.core.lang.Console;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class CourseDeleteDemoApp {

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
                Console.log("获取 id 为 {} 讲师的基础数据: {}", theInstructorId, instructor);
                Console.log("获取 id 为 {} 讲师的详细数据: {}", theInstructorId, instructor.getInstructorDetail());
                Console.log("获取 id 为 {} 讲师的课程数据: {}", theInstructorId, instructor.getCourses());

                // 删除讲师的其中一个课程
                Course course = instructor.getCourses().get(0);
                session.remove(course);
                Console.log("删除课程: {}", course);

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
