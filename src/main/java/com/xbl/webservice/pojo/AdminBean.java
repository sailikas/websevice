package com.xbl.webservice.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("my_admin")
@ApiModel("admin的实体类")
public class AdminBean {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    @TableField("password")
    private String name;
    @TableField("name")
    private String password;
    @Version
    private Integer version;
    @TableLogic(value = "1",delval = "0")//归0就没了
    private Integer deleted;
}
