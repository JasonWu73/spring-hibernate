package org.example.springhibernate.student;

import cn.hutool.core.lang.Console;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentReadDemoApp {

    public static void main(String[] args) {
        // 创建 SessionFactory
        try (
            SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()
        ) {
            // 获取 Session
            Session session = sessionFactory.getCurrentSession();

            // 构建需要保存的数据
            Student jason = new Student("Jason", "Wu", "jasonwu@163.com");

            // 开启事务
            Transaction transaction = session.beginTransaction();

            // 保存数据i
            session.persist(jason);

            // 提交事务, 会关闭当前 Session
            transaction.commit();

            // 打印已保存的数据 id
            Console.log("保存数据: {}", jason);

            // 查询已保存的 id, 需打开 Session, 并开启事务
            Session newSession = sessionFactory.getCurrentSession();
            newSession.beginTransaction();
            Student savedJason = newSession.get(Student.class, jason.getId());
            Console.log("读取 id 为 {} 的学生: {}", jason.getId(), savedJason);
        }
    }
}
