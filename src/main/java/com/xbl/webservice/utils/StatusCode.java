package com.xbl.webservice.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StatusCode {
    private Integer code;
    private String msg;

    public static StatusCode successCode(){return new StatusCode(200, "成功");}
    public static StatusCode failedCode(){return new StatusCode(499, "失败");}

}
