package org.example.springhibernate.instructor;

import cn.hutool.core.lang.Console;
import org.example.springhibernate.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CourseStudentDemoApp {

    public static void main(String[] args) {
        // 创建 Hibernate Session Factory
        try (
            SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()
        ) {
            // 获取 Hibernate Session
            Session session = sessionFactory.getCurrentSession();

            // 开启事务
            Transaction transaction = session.beginTransaction();

            try {
                // 测试创建课程及其学生
                // testSaveCourseStudent(session);

                // 测试获取课程及其学生
                testGetCourseStudent(session);

                // 测试删除课程及其学生
                // testDeleteCourseStudent(session);

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
     * 测试删除课程及学生。
     * <p>
     * 本方法不会提交或回滚事务，故需在本方法之外进行事务处理。
     *
     * @param session Hibernate Session
     */
    private static void testDeleteCourseStudent(Session session) {
        // 获取课程
        long courseId = 7;
        Course course = getCourseById(session, courseId);

        // 删除课程
        session.remove(course);
    }

    /**
     * 测试获取课程及学生。
     * <p>
     * 本方法不会提交或回滚事务，故需在本方法之外进行事务处理。
     *
     * @param session Hibernate Session
     */
    private static void testGetCourseStudent(Session session) {
        // 获取课程
        long courseId = 9;
        Course course = getCourseById(session, courseId);

        // 获取学生
        Console.log("id 为 {} 课程的学生: {}", courseId, course.getStudents());
    }

    /**
     * 测试保存课程的同时也会保存对应的学生。
     * <p>
     * 本方法不会提交或回滚事务，故需在本方法之外进行事务处理。
     *
     * @param session Hibernate Session
     */
    private static void testSaveCourseStudent(Session session) {
        // 保存课程
        Course course = new Course("课程：莫天磊", null);
        session.persist(course);

        // 构建需要保存的学生
        Student student1 = new Student("健雄", "黄", "quinton.albert@example.com");
        Student student2 = new Student("烨霖", "郭", "jeannine.robinson@example.com");

        // 保存学生
        session.persist(student1);
        session.persist(student2);

        // 设置课程与学生的关联关系，本步骤与保存学生的步骤没有先后关系
        course.addStudent(student1);
        course.addStudent(student2);

        // 保存课程
        session.persist(course);
    }

    /**
     * 获取数据库中的某个课程。
     *
     * @param session  hibernate session
     * @param courseId 课程 id
     * @return 指定 id 的课程
     */
    private static Course getCourseById(Session session, long courseId) {
        Course course = session.get(Course.class, courseId);
        Console.log("id 为 {} 的课程: {}", courseId, course);
        return course;
    }
}
