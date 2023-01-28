package org.example.springhibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注解 Demo 主程序.
 *
 * @author 吴仙杰
 **/
public class AnnotationDemoApp {

    public static void main(String[] args) {
        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        // get the bean from spring container
        Coach coach = context.getBean("thatSillyCoach", Coach.class);

        // call a method on the bean
        System.out.println(coach.getDailyWorkout());

        // close the context
        context.close();
    }
}
