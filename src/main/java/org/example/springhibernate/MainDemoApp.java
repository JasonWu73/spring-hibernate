package org.example.springhibernate;

import org.example.springhibernate.config.AppConfig;
import org.example.springhibernate.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(final String[] args) {
        // read spring config java class
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // get the bean from spring container
        final AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        // call the business method
        accountDao.addAccount();

        // close the context
        context.close();
    }
}
