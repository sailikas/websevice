package com.xbl.webservice.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Result {
    private StatusCode code;
    private List data;

    public static Result success(List data){
        return new Result(StatusCode.successCode(), data);
    }
    public static Result failed(List data){
        return new Result(StatusCode.failedCode(), data);
    }
}
