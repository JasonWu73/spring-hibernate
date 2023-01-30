package org.example.springhibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试通过 Bean 定义.
 *
 * @author 吴仙杰
 **/
public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {
        // read spring config Java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        Coach swimCoach = context.getBean("swimCoach", Coach.class);
        Coach footballCoach = context.getBean("footballCoach", Coach.class);

        // call a method on the bean
        System.out.println(swimCoach.getDailyWorkout());
        System.out.println(swimCoach.getDailyFortune());
        System.out.println(footballCoach.getDailyWorkout());
        System.out.println(footballCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
