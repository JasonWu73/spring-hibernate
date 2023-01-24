package org.example.springhibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 吴仙杰
 **/
public class HelloSpringApp {

    public static void main(String[] args) {
        // 加载 Spring 配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        // 从 Spring 容器中获取 Bean
        Coach coach = context.getBean("coach", Coach.class);

        // 调用 Bean 中的方法
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        // 关闭 Spring 上下文
        context.close();
    }
}
