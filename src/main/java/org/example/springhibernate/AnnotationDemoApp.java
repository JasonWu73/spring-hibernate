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
        Coach coach = context.getBean("tennisCoach", Coach.class);

        // call a method on the bean
        System.out.println(coach.getDailyWorkout());

        // call method to get the daily fortune
        System.out.println(coach.getDailyFortune());

        // call method to get injected value
        TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        System.out.println(tennisCoach.getEmail());
        System.out.println(tennisCoach.getTeam());

        // close the context
        context.close();
    }
}
