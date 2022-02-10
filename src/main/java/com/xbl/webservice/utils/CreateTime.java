package com.xbl.webservice.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class CreateTime {
    public  static String createTime(){
        DateFormat dateFormat = new SimpleDateFormat("ddMMyy_HHmmss");
        Date date = new Date();
        String dateStr = dateFormat.format(date);
        return dateStr;
    }
}
