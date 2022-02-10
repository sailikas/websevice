package com.xbl.webservice.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()  // 验证请求
                    // 路径匹配，参数是要处理的 url
                    .antMatchers("/admin/**").hasRole("admin")  // 要具有某种权限
                    .antMatchers("/user/**").hasAnyRole("admin", "user")// 要具有某种权限中的一种
                    .anyRequest().authenticated();
        }


}

