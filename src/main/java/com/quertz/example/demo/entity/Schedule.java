package com.quertz.example.demo.entity;

import lombok.Data;

/**
 * @Author: eros
 * @Description:
 * @Date: Created in 2020/1/15 14:06
 * @Version: 1.0
 * @Modified By:
 */
@Data
public class Schedule {

    // 任务名称
    private String jobName;

    // 任务组
    private String jobGroup;

    // cron 表达式
    private String expression;

}
