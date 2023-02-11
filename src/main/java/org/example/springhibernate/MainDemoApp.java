package org.example.springhibernate;

import org.example.springhibernate.config.AppConfig;
import org.example.springhibernate.dao.AccountDao;
import org.example.springhibernate.dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(final String[] args) {
        // read spring config java class
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        final AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        accountDao.addAccount();

        System.out.println();

        final MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);
        membershipDao.addAccount();

        // close the context
        context.close();
    }
}
