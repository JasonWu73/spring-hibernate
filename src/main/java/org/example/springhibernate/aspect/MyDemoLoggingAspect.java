package org.example.springhibernate.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* org.example.springhibernate.dao.*.*(..))")
    private void pointcutForDaoPackageMethod() {
    }

    // execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
    @Before("pointcutForDaoPackageMethod()")
    public void beforeAddAccountAdvice() {
        System.out.println("=====> Executing @Before advice on the method");
    }
}
