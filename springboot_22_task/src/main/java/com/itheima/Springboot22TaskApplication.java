package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//开启定时任务功能
@EnableScheduling//spring task需要使用注解@EnableScheduling开启定时任务功能
public class Springboot22TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot22TaskApplication.class, args);
    }
}