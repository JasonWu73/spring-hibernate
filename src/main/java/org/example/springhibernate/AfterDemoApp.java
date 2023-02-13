package org.example.springhibernate;

import cn.hutool.core.lang.Console;
import org.example.springhibernate.config.AppConfig;
import org.example.springhibernate.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterDemoApp {

  public static void main(final String[] args) {
    final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    final AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

    Console.log("\nCall find accounts method when no exception");
    accountDao.findAccounts(false);

    try {
      Console.log("\nCall find accounts method when throw exception");
      accountDao.findAccounts(true);
    } catch (Exception e) {
      Console.error("Catch expected exception: {}", e);
    }

    context.close();
  }
}
