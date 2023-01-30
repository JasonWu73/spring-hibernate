package org.example.springhibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Java 类配置 (无 XML) Demo 主程序.
 *
 * @author 吴仙杰
 **/
public class JavaConfigDemoApp {

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        Coach coach = context.getBean("tennisCoach", Coach.class);

        // call a method on the bean
        System.out.println(coach.getDailyWorkout());

        // call method to get the daily fortune
        System.out.println(coach.getDailyFortune());

        // close the context
        context.close();
    }
}
