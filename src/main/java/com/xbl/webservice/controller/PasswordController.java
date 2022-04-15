package com.xbl.webservice.controller;


import com.xbl.webservice.entity.Password;
import com.xbl.webservice.service.impl.PasswordServiceImpl;
import com.xbl.webservice.utils.Result;
import com.xbl.webservice.vo.UserVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author author
 * @since 2022-04-13
 */
@Controller
@RequestMapping("/user")
@CrossOrigin("*")
@Log4j2
public class PasswordController {

    @Autowired
    PasswordServiceImpl service;


    @GetMapping("register")
    public String register(@RequestParam("uname") String uname,
                           @RequestParam("password") String password) {
        if (service.register(new UserVo(uname, password))) {
            log.info("跳到index");
            return "/";
        }
        log.info("跳到register");
        return "/register.html";

    }
}
