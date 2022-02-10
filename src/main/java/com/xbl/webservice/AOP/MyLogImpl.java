package com.xbl.webservice.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component//注册Bean
@Aspect//标注切面类
public class MyLogImpl {
    @Pointcut("@annotation(com.xbl.webservice.AOP.myLog)")//切点
    public void pt(){}
//
//    @Before("pt()")
//    public void foo(){
//        System.out.println("AOP before foo");
//    }
    @Around("pt()")
    public Object foo2(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getName();
        System.out.println("环绕执行前:"+name+"被执行");
        Object res = joinPoint.proceed();
        System.out.println("环绕执行后:"+name+"返回值"+res);
        return res;
    }
    
}
