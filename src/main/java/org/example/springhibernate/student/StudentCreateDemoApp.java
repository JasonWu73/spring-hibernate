package org.example.springhibernate.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentCreateDemoApp {

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
            Student me = new Student("仙杰", "吴", "wuxianjiezh@163.com");
            Student zhangSan = new Student("三", "张", "zhangsan@163.com");
            Student liSi = new Student("四", "李", "lisi@163.com");

            // 开启事务
            Transaction transaction = session.beginTransaction();

            // 保存数据i
            session.persist(me);
            session.persist(zhangSan);
            session.persist(liSi);

            // 提交事务
            transaction.commit();
        }
    }
}
