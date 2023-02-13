package org.example.springhibernate.aspect;

import cn.hutool.core.lang.Console;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.springhibernate.dto.Account;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

  @Around("execution(* org.example.springhibernate.dao.AccountDao.findAccounts(..))")
  public Object aroundFindAccountsAdvice(final ProceedingJoinPoint joinPoint) throws Throwable {
    final String methodName = joinPoint.getSignature().toShortString();
    Console.log("-> @Around: {}", methodName);

    final long startMilliseconds = System.currentTimeMillis();

    try {
      final Object result = joinPoint.proceed();
      Console.log("-> @Around: result={}", result);
      return result;
    } catch (Throwable e) {
      Console.log("-> @Around: handle exception: {}", e);
      throw e;
    } finally {
      final long endMilliseconds = System.currentTimeMillis();
      Console.log("Executing cost {} milliseconds", endMilliseconds - startMilliseconds);
    }
  }

  @After("execution(* org.example.springhibernate.dao.AccountDao.findAccounts(..))")
  public void afterFindAccountsAdvice(final JoinPoint joinPoint) {
    final String methodName = joinPoint.getSignature().toShortString();
    Console.log("-> @After: {}", methodName);
  }

  @AfterThrowing(
    pointcut = "execution(java.util.List org.example.springhibernate.dao.AccountDao.findAccounts(..))",
    throwing = "exc"
  )
  public void afterReturningFindAccountsAdvice(final JoinPoint joinPoint, final Throwable exc) {
    final String methName = joinPoint.getSignature().toShortString();
    Console.log("-> @AfterThrowing call method: {}", methName);
    Console.log("-> Log exception: {}", exc);
    // throw new RuntimeException("@AfterThrowing test exception");
  }

  @AfterReturning(
    pointcut = "execution(java.util.List org.example.springhibernate.dao.AccountDao.findAccounts(..))",
    returning = "result"
  )
  public void afterReturningFindAccountsAdvice(final JoinPoint joinPoint, final List<Account> result) {
    final String methName = joinPoint.getSignature().toShortString();
    Console.log("-> @AfterReturning call method: {}", methName);

    Console.log("-> Original Result:\n{}", result);

    result.forEach(acct -> {
      if (!acct.getName().equals("John")) return;

      acct.setName("Changed: " + acct.getName());
      acct.setLevel("Changed: " + acct.getLevel());
    });
  }

  // execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
  @Before("org.example.springhibernate.aspect.PointcutAspect.forDaoPkgNoGetterSetter()")
  public void beforeAddAccountAdvice(final JoinPoint joinPoint) {
    System.out.println("-> @Before: executing demo logging");

    final MethodSignature methSig = (MethodSignature) joinPoint.getSignature();
    System.out.println("-> Method: " + methSig);

    Arrays.stream(joinPoint.getArgs())
      .forEach(arg -> Console.log("-> arg: {}: {}", arg.getClass(), arg));
  }
}
