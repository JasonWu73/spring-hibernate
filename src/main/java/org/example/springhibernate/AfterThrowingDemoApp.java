package org.example.springhibernate;

import cn.hutool.core.lang.Console;
import org.example.springhibernate.config.AppConfig;
import org.example.springhibernate.dao.AccountDao;
import org.example.springhibernate.dto.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(final String[] args) {
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        final AccountDao accountDao = ctx.getBean("accountDao", AccountDao.class);
        final List<Account> accounts = accountDao.findAccounts(true);
        Console.log("AccountDao After Returning:\n{}", accounts);

        ctx.close();
    }
}
