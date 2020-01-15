package com.quertz.example.demo.config;

import com.quertz.example.demo.config.properties.QuartzProperties;
import com.quertz.example.demo.manage.jobFactory.QuartzJobFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Properties;

/**
 * @Author: eros
 * @Description:
 * @Date: Created in 2020/1/15 10:44
 * @Version: 1.0
 * @Modified By:
 */
@Configuration
public class QuartzConfig {

    @Autowired
    private QuartzProperties quartzProperties;

    @Autowired
    private QuartzJobFactory quartzJobFactory;

    public Properties loadPro(){
        Properties prop = new Properties();
        prop.put(StdSchedulerFactory.PROP_THREAD_POOL_PREFIX + QuartzProperties.THREAD_COUNT, quartzProperties.getThreadPoolThreadCount());
        prop.put(StdSchedulerFactory.PROP_THREAD_POOL_PREFIX + QuartzProperties.THREAD_PRIORITY, quartzProperties.getThreadPoolThreadPriority());
        prop.put(StdSchedulerFactory.PROP_THREAD_POOL_PREFIX + QuartzProperties.THREADS_INHERIT_CONTEXT_CLASSLOADER_OF_INITIALIZING_THREAD, quartzProperties.getThreadPoolThreadsInheritContextClassLoaderOfInitializingThread());
        prop.put(StdSchedulerFactory.PROP_THREAD_POOL_CLASS, quartzProperties.getThreadPoolClass());
        prop.put(StdSchedulerFactory.PROP_JOB_STORE_PREFIX + QuartzProperties.MISFIRE_THRESHOLD, quartzProperties.getJobStoreMisfireThreshold());
        prop.put(StdSchedulerFactory.PROP_JOB_STORE_CLASS, quartzProperties.getJobStoreClass());
        prop.put(StdSchedulerFactory.PROP_SCHED_INSTANCE_NAME, quartzProperties.getSchedulerInstanceName());
        prop.put(StdSchedulerFactory.PROP_SCHED_WRAP_JOB_IN_USER_TX, quartzProperties.getSchedulerWrapJobExecutionInUserTransaction());
        prop.put(StdSchedulerFactory.PROP_SCHED_RMI_EXPORT, quartzProperties.getSchedulerRmiExport());
        prop.put(StdSchedulerFactory.PROP_SCHED_RMI_PROXY, quartzProperties.getSchedulerRmiProxy());
        return prop;
    }

    // 下面是两种方式，一种是 使用配置文件 创建 SchedulerFactory 实例后，存放入 SchedulerFactoryBean 中，
    // 另一种是 使用配置文件直接创建 SchedulerFactoryBean， 它会自动创建 SchedulerFactory 实例
    // 刚开始没有在意, 所以使用第一种方式，饶了一大圈

//    @Bean
//    public SchedulerFactory schedulerFactory(){
//        SchedulerFactory schedulerFactory = null;
//        try {
//            schedulerFactory = new StdSchedulerFactory(loadPro());
//        } catch (SchedulerException e) {
//            schedulerFactory =  new StdSchedulerFactory();
//        }
//        return schedulerFactory;
//    }
//
//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean(SchedulerFactory schedulerFactory){
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//            schedulerFactoryBean.setSchedulerFactory(schedulerFactory);
//        return schedulerFactoryBean;
//    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(quartzJobFactory);
        schedulerFactoryBean.setSchedulerName("scheduler_demo");
        schedulerFactoryBean.setQuartzProperties(loadPro());
        return schedulerFactoryBean;
    }

}
