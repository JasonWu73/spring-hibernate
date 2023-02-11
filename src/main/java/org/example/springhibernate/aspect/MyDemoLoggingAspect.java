package org.example.springhibernate.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* org.example.springhibernate.dao.*.*(..))")
    private void forDaoPkg() {
    }

    @Pointcut("execution(* org.example.springhibernate.dao.*.get*())")
    private void getter() {
    }

    @Pointcut("execution(* org.example.springhibernate.dao.*.set*(*))")
    private void setter() {
    }

    @Pointcut("forDaoPkg() && !(getter() || setter())")
    private void forDaoPkgExcludeGetterSetter() {
    }

    // execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
    @Before("forDaoPkgExcludeGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("=====> Executing @Before advice on the method");
    }

    @Before("forDaoPkgExcludeGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("=====> Performing API Analytics");
    }
}
