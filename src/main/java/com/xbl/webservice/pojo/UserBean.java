package com.xbl.webservice.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
@TableName("password")
public class UserBean {
    @TableId(type = IdType.ASSIGN_ID)
    private String uid;                         //用户id
    private String username;                    //用户名
    private String password;                    //用户密码
    private Date createTime;                    //注册时间



}
