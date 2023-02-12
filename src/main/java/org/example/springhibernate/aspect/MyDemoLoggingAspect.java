package org.example.springhibernate.aspect;

import cn.hutool.core.lang.Console;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
    @Before("org.example.springhibernate.aspect.PointcutAspect.forDaoPkgNoGetterSetter()")
    public void beforeAddAccountAdvice(final JoinPoint joinPoint) {
        System.out.println("-> Executing Demo Logging");

        final MethodSignature methSig = (MethodSignature) joinPoint.getSignature();
        System.out.println("-> Method: " + methSig);

        Arrays.stream(joinPoint.getArgs())
            .forEach(arg -> Console.log("-> arg: {}: {}", arg.getClass(), arg));
    }
}
