package org.example.springhibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 吴仙杰
 **/
public class BeanScopeDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("bean-scope-application-context.xml");

        Coach coach1 = context.getBean("coach", Coach.class);
        Coach coach2 = context.getBean("coach", Coach.class);

        boolean isSame = coach1 == coach2;

        System.out.println("coach1 == coach2: " + isSame);
        System.out.println("coach1 memory location: " + coach1);
        System.out.println("coach2 memory location: " + coach2);

        context.close();
    }
}
