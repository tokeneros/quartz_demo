package com.quertz.example.demo.config.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: eros
 * @Description:
 * @Date: Created in 2020/1/15 14:21
 * @Version: 1.0
 * @Modified By:
 */
@Component
@Data
public class QuartzProperties {

    public static final String PREFIX = "spring.quartz.properties";

    @Value(value =  "${"+ PREFIX +".jobStore.class}")
    public String jobStoreClass;

    public static final String MISFIRE_THRESHOLD = ".misfireThreshold";

    @Value(value =  "${"+ PREFIX +".jobStore.misfireThreshold}")
    public String jobStoreMisfireThreshold;

    @Value(value =  "${"+ PREFIX +".threadPool.class}")
    public String threadPoolClass;

    public static final String THREAD_COUNT = ".threadCount";

    @Value(value =  "${"+ PREFIX +".threadPool.threadCount}")
    public String threadPoolThreadCount;

    public static final String THREAD_PRIORITY = ".threadPriority";

    @Value(value =  "${"+ PREFIX +".threadPool.threadPriority}")
    public String threadPoolThreadPriority;

    public static final String THREADS_INHERIT_CONTEXT_CLASSLOADER_OF_INITIALIZING_THREAD = ".threadsInheritContextClassLoaderOfInitializingThread";

    @Value(value =  "${"+ PREFIX +".threadPool.threadsInheritContextClassLoaderOfInitializingThread}")
    public String threadPoolThreadsInheritContextClassLoaderOfInitializingThread;

    @Value(value =  "${"+ PREFIX +".scheduler.instanceName}")
    public String schedulerInstanceName;

    @Value(value =  "${"+ PREFIX +".scheduler.wrapJobExecutionInUserTransaction}")
    public String schedulerWrapJobExecutionInUserTransaction;

    @Value(value =  "${"+ PREFIX +".scheduler.rmi.export}")
    public String schedulerRmiExport;

    @Value(value =  "${"+ PREFIX +".scheduler.rmi.proxy}")
    public String schedulerRmiProxy;

}
