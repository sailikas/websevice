package com.xbl.webservice.config;

import com.xbl.webservice.service.impl.PasswordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordServiceImpl passwordService;




    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .mvcMatchers("/user/**","/login","/login.html","/register","/swagger-ui.html","/swagger-resources/**","/webjars/**",
                        "/*/api-docs","/css/**", "/js/**", "/index.html", "/img/**", "/fonts/**", "/favicon.ico", "/verifyCode",
                        "/*.svg","/*.png","/*.js","/**.css")
                .permitAll()
                .antMatchers("/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
//                .successForwardUrl("/index.html")                             //成功跳转去 主页 同表单一样的请求方法 method
                .defaultSuccessUrl("/")                                 //成功跳转去 主页 GET
                .loginPage("/login.html")                           //自定义登录页 登录页的表单name写username和password路径写处理登录的路径
                .loginProcessingUrl("/login")                       //如果自定义登录页需要下写 处理登录的url
                .and()
                .csrf().disable();


    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(passwordService);
    }

    /**
     * 指定加密方式
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 使用BCrypt加密密码
        return new BCryptPasswordEncoder();
    }


}

