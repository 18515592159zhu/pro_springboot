package com.itheima.controller;

import com.itheima.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 13:28
 * @Version 1.0
 */
@RestController
@RequestMapping("/msgs")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public String doMessage() {
        String id = messageService.doMessage();
        return id;
    }
}