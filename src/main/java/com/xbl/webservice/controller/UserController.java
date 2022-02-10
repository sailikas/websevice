package com.xbl.webservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xbl.webservice.pojo.UserBean;
import com.xbl.webservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("user")
@Api(tags = {"用户controller"})
@Log4j2
public class UserController {

  @Autowired
  UserService us;



  /**
   * 用户管理相关
   * @param user
   */
  @PostMapping("register")
  public void userRegister(@RequestBody UserBean user) {
    user.builder().createTime(new Date()).capacity(0).build();
    log.info(user);
    QueryWrapper wrapper = new QueryWrapper();
    wrapper.eq("username",user.getUsername());
    UserBean one = us.getOne(wrapper);
    System.out.println("on = " + one);
//    us.save(user);
    //// TODO: 2022/1/16 写入数据库
  }

  @ApiOperation("接受类型Content-Type:application/x-www-form-urlencoded或者multipart/form-data")
  @PostMapping("login")
  public boolean login(
      @RequestParam("username") String username, @RequestParam("password") String password) {
    // TODO: 2022/1/16 查询数据库

    QueryWrapper wrapper = new QueryWrapper<>();
//    wrapper.eq("username", username).eq("password", password);
    UserBean userBean = us.getOne(wrapper);
    if (userBean != null) {
      return userBean.getPassword().equals(password);
    }
    return false;
  }




}
