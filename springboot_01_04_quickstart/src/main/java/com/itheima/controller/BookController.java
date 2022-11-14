package com.itheima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhuchifeng
 * @Date 2022/10/23 6:49
 * @Version 1.0
 */
//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getById() {
        System.out.println("springboot is running...4");
        return "springboot is running...4";
    }
}
