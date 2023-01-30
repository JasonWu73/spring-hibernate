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
        SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);

        // call a method on the bean
        System.out.println(swimCoach.getEmail());
        System.out.println(swimCoach.getTeam());

        // close the context
        context.close();
    }
}
