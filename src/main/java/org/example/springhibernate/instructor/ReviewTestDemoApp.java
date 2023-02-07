package org.example.springhibernate.instructor;

import cn.hutool.core.lang.Console;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReviewTestDemoApp {

    public static void main(String[] args) {
        // 获取 Hibernate Session Factory
        try (
            SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()
        ) {
            // 获取 Session 并开启事务
            Session session = sessionFactory.getCurrentSession();
            Transaction transaction = session.beginTransaction();

            try {
                // 创建新课程并保存对其的评论
                // testSaveCourseReview(session);

                // 获取课程，观察评论数据是否为延迟加载
                // testGetCourseReview(session);

                // 删除课程，观察该课程的评论是否也一并被删除
                testDeleteCourseReview(session);

                // 正常流程，提交事务
                transaction.commit();
            } catch (Exception e) {
                // 异常流程，回滚事务
                transaction.rollback();

                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 删除课程，该课程的评论也会被一并被删除。
     * <p>
     * <strong>注意：</strong>本方法不会提交或回滚事务。
     *
     * @param session Hibernate Session
     */
    private static void testDeleteCourseReview(Session session) {
        // 获取课程
        int courseId = 5;
        Course course = getCourse(session, courseId);

        // 删除课程
        session.remove(course);
    }

    /**
     * 测试获取课程，同时通过延迟加载获取其评论。
     * <p>
     * <strong>注意：</strong>本方法不会提交或回滚事务。
     *
     * @param session Hibernate Session
     */
    private static void testGetCourseReview(Session session) {
        // 获取课程
        int courseId = 5;
        Course course = getCourse(session, courseId);

        // 通过延迟加载获取课程的评论
        List<Review> reviews = course.getReviews();
        Console.log("id 为 {} 的课程评论：{}", courseId, reviews);
    }

    /**
     * 测试保存课程的同时也一并保存其评论。
     * <p>
     * <strong>注意：</strong>本方法不会提交或回滚事务。
     *
     * @param session Hibernate Session
     */
    private static void testSaveCourseReview(Session session) {
        // 构建课程及评论数据
        long instructorId = 1;
        Instructor instructor = session.get(Instructor.class, instructorId);
        Course course = new Course("课程：彭鹭洋", instructor);
        Review review = new Review("Dark and difficult times lie ahead. Soon we must all face the choice between what is right and what is easy.");
        course.addReview(review);

        // 保存课程，观察评论也应该会被一并保存
        session.persist(course);
    }

    /**
     * 获取某个课程。
     *
     * @param session  Hibernate Session
     * @param courseId 课程 id
     * @return 课程
     */
    private static Course getCourse(Session session, int courseId) {
        Course course = session.get(Course.class, courseId);
        Console.log("id 为 {} 的课程：{}", courseId, course);
        return course;
    }
}
