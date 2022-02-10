package com.xbl.webservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xbl.webservice.AOP.isLogin;
import com.xbl.webservice.pojo.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<UserBean> {
}
