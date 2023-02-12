package org.example.springhibernate.aspect;

import cn.hutool.core.lang.Console;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
