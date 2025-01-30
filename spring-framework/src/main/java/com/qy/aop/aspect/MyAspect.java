package com.qy.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.qy.aop.aspect.DogService.run())")
    public void a(){

    }
    @Before("a()")
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("myBefore");
    }

}
