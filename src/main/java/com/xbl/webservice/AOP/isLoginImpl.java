package com.xbl.webservice.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class isLoginImpl {
    @Pointcut("@annotation(com.xbl.webservice.AOP.isLogin)")
    public void pt(){}
    @Before("pt()")
    public void isLogin(){
        //获取用户登录状态
        System.out.println("用户登录了");
        //转发
    }
}
