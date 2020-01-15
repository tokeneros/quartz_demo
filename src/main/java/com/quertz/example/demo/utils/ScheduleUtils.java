package com.quertz.example.demo.utils;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import java.text.ParseException;
import java.util.Date;

/**
 * @Author: eros
 * @Description:
 * @Date: Created in 2020/1/15 17:01
 * @Version: 1.0
 * @Modified By:
 */
public class ScheduleUtils {

    public static void nextTime(String expression, Integer count) throws ParseException {
        CronExpression cronExpression = new CronExpression(expression);
        Date date = new Date();
        while(count-- > 0){
            date = cronExpression.getTimeAfter(date);
            System.out.println(DateUtils.formatDate(date));
        }
    }

    public static void main(String[] args) {
        try {
            nextTime("0/20 * * * * ?",10);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
