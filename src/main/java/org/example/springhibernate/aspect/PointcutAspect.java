package org.example.springhibernate.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutAspect {

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
    public void forDaoPkgNoGetterSetter() {
    }
}
