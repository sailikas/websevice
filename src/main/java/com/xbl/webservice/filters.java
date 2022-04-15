package com.xbl.webservice;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "*") //需要过滤的url 是一个数组类型的,可以存多个
public class filters implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        //这个过滤是在执行的方法前面的,就是先执行过滤,在进去gethello
//        response.setCharacterEncoding("utf-8");
//        System.out.println("request.getContentType() = " + request.getContentType());
        //chain:链 不使用这个程序就会卡在这里,进不去url的方法
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
