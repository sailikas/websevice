package com.xbl.webservice.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xbl.webservice.mapper.UserMapper;
import com.xbl.webservice.pojo.UserBean;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserBean> implements UserService {
}
