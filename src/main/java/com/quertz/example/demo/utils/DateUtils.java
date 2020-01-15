package com.quertz.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: eros
 * @Description:
 * @Date: Created in 2020/1/15 17:14
 * @Version: 1.0
 * @Modified By:
 */
public class DateUtils {

    public static final Calendar calender = Calendar.getInstance();

    public static final String DATETIME = "yyyy-MM-dd HH:mm:ss";

    public static final SimpleDateFormat sdfd = new SimpleDateFormat(DATETIME);

    public static String formatDate(Date date){
        return sdfd.format(date);
    }

    public static String getNowDateTime(){
        return sdfd.format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(formatDate(new Date()));
    }

}
