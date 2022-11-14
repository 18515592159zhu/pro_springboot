package com.itheima.config;

import com.itheima.quartz.MyQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 8:57
 * @Version 1.0
 */
//创建Quartz配置类，定义工作明细（JobDetail）与触发器的（Trigger）bean
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail printJobDetail() {
        //绑定具体的工作
        return JobBuilder
                .newJob(MyQuartz.class)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger printJobTrigger() {
        ScheduleBuilder schedBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        //绑定对应的工作明细
        return TriggerBuilder.newTrigger().forJob(printJobDetail()).withSchedule(schedBuilder).build();
    }
}