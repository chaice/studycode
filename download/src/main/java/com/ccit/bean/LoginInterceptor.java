package com.ccit.bean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Administrator on 2017/6/2.
 */
@Aspect
public class LoginInterceptor {
    @Pointcut("execution(* com.ccit.service.*.*())")
    public void pointcut(){

    }
    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint){
        System.err.println("这是前置通知!");
        System.err.println(joinPoint.getTarget().getClass());
    }
    @After(value = "pointcut()")
    public void after(){
        System.err.println("这是后置通知!");
    }
}
