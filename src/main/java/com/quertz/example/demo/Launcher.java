package com.quertz.example.demo;

import com.quertz.example.demo.manage.job.TimingOutputJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Author: eros
 * @Description:
 * @Date: Created in 2020/1/15 14:04
 * @Version: 1.0
 * @Modified By:
 */
@Component
public class Launcher implements CommandLineRunner {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Quartz Start ...");
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.start();
        // 创建一个任务
        JobDetail jobDetail = JobBuilder.newJob(TimingOutputJob.class)
                .withIdentity("job_name","group_name")
                .build();
        Trigger trigger = TriggerBuilder.newTrigger().forJob(jobDetail).startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

}
