package com.xbl.webservice.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2022-04-13
 */
@RestController
@RequestMapping("/as")
public class UmessageController {
    @PostMapping
    public void foo(HttpServletRequest req){
        System.out.println("req.toString() = " + req.toString());
    }

}
