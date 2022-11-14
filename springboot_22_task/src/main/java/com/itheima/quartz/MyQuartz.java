package com.itheima.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 8:56
 * @Version 1.0
 */
//定义任务Bean，按照Quartz的开发规范制作，继承QuartzJobBean
public class MyQuartz extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("quartz task run...");
    }
}
