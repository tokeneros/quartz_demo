package com.quertz.example.demo.manage.jobFactory;

import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: eros
 * @Description: 我们自己实现的Job Factory 必须 要实现 AdaptableJobFactory
 * @Date: Created in 2020/1/15 16:30
 * @Version: 1.0
 * @Modified By:
 */
@Component
public class QuartzJobFactory extends AdaptableJobFactory {

    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    @Override
    public Job newJob(TriggerFiredBundle bundle, Scheduler scheduler) throws SchedulerException {
        System.out.println("newJob");
        return super.newJob(bundle, scheduler);
    }

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        System.out.println("createJobInstance");
        return super.createJobInstance(bundle);
    }

    @Override
    protected Job adaptJob(Object jobObject) throws Exception {
        System.out.println("adaptJob");
        return super.adaptJob(jobObject);
    }
}
