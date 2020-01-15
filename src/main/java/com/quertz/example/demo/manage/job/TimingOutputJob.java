package com.quertz.example.demo.manage.job;

import com.quertz.example.demo.utils.DateUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author: eros
 * @Description: 定时输出时间
 * @Date: Created in 2020/1/15 16:38
 * @Version: 1.0
 * @Modified By:
 */
public class TimingOutputJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(String.format("TIME OUTPUT : %s, CLASS : %s, GROUP : %s, NAME : %s",
                new Object[] { DateUtils.getNowDateTime(), context.getJobDetail().getJobClass(), context.getJobDetail().getKey().getGroup() , context.getJobDetail().getKey().getName()}));
    }

}
