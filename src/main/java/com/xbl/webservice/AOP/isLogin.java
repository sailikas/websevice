package com.xbl.webservice.AOP;


import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface isLogin {
    String value() default "";
}
