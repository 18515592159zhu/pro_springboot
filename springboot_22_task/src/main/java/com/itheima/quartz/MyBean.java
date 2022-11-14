package com.itheima.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 8:56
 * @Version 1.0
 */
@Component
public class MyBean {

    @Scheduled(cron = "0/1 * * * * ?")
    public void print() {
        System.out.println(Thread.currentThread().getName() + " :spring task run...");
    }
}