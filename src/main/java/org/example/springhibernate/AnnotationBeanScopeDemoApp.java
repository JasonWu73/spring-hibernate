package org.example.springhibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试 Bean Scope 的主程序.
 *
 * @author 吴仙杰
 **/
public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {
        // load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        // retrieve bean from spring container
        Coach coachOne = context.getBean("tennisCoach", Coach.class);
        Coach coachTwo = context.getBean("tennisCoach", Coach.class);

        // check if they are the same
        boolean isSame = (coachOne == coachTwo);

        // print out the results
        System.out.println("coachOne == coachTwo: " + isSame);
        System.out.println("memory location of coachOne: " + coachOne);
        System.out.println("memory location of coachTwo: " + coachTwo);

        // close the context
        context.close();
    }
}
