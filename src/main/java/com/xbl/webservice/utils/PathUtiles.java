package com.xbl.webservice.utils;

public class PathUtiles {
    public static String classpath(){
        return new PathUtiles().getClass().getResource("/").getPath().toString();
    }
    public static String userName(){
        return "";
    }
}
