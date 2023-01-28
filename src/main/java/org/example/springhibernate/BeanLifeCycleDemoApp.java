package org.example.springhibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 吴仙杰
 **/
public class BeanLifeCycleDemoApp {

    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("bean-life-cycle-application-context.xml");

        // retrieve bean from spring container
        Coach coach = context.getBean("coach", Coach.class);
        System.out.println(coach.getDailyWorkout());

        // close the context
        context.close();
    }
}
