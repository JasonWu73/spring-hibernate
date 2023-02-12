package org.example.springhibernate.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    // execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
    @Before("org.example.springhibernate.aspect.PointcutAspect.forDaoPkgNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("=====> Performing API Analytics");
    }
}