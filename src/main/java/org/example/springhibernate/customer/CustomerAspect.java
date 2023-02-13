package org.example.springhibernate.customer;

import cn.hutool.core.lang.Console;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerAspect {

  @Pointcut("execution(public * org.example.springhibernate.customer.*Controller.*(..))")
  private void customerOperationPointcut() {
  }

  @Before("customerOperationPointcut()")
  public void beforeCustomerOperation(final JoinPoint joinPoint) {
    final String methodName = joinPoint.getSignature().toShortString();
    Console.log("=====> @Before: {}", methodName);
  }

  @AfterReturning(
    pointcut = "customerOperationPointcut()",
    returning = "result"
  )
  public void afterReturningCustomerOperation(final JoinPoint joinPoint, final Object result) {
    final String methodName = joinPoint.getSignature().toShortString();
    Console.log("=====> @AfterReturning: {}, Result: {}", methodName, result);
  }
}
