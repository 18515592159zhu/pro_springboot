package com.itheima.controller;

import com.itheima.pojo.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhuchifeng
 * @Date 2022/10/25 22:53
 * @Version 1.0
 */
@RestController
@RequestMapping("/books")
public class BookController {
//    @GetMapping
//    public String getById() {
//        System.out.println("getById is running .....");
//        return "springboot";
//    }

    @GetMapping
    public Book getById() {
        System.out.println("getById is running .....");
        Book book = new Book();
        book.setId(1);
        book.setName("springboot");
        book.setType("springboot");
        book.setDescription("springboot");
        return book;
    }
}
