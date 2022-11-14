package com.itheima.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhuchifeng
 * @Date 2022/10/25 5:00
 * @Version 1.0
 * 基于lombok提供的@Slf4j注解为类快速添加日志对象
 */
//Rest模式
@Slf4j//这个注解替代了下面那一行
@RestController
@RequestMapping("/books")
public class BookController {

    //这一句可以不写了
    //private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public String getById() {
        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");
        System.out.println("springboot is running...");
        return "springboot is running...";
    }
}