package com.itheima.controller;

import com.itheima.Enterprise;
import com.itheima.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhuchifeng
 * @Date 2022/10/23 7:25
 * @Version 1.0
 */
//Rest模式
@RestController
@RequestMapping("/books")
public class BookControlelr {

    //读取yaml数据中的单一数据
    @Value("${country}")
    private String country;

    @Value("${port}")
    private String port;

    @Value("${server.port}")
    private String serverPort;

    @Value("${party}")
    private String party;

    @Value("${birthday}")
    private String birthday;

    @Value("${user2.name}")
    private String name;

    @Value("${likes[1]}")
    private String likes1;

    @Value("${likes2[1]}")
    private String likes2;

    @Value("${users[1].age}")
    private String age1;

    @Value("${tempDir}")
    private String tempDir;

    @Value("${tempDir2}")
    private String tempDir2;

    @Value("${lesson}")
    private String lesson;

    @Value("${enterprise.subject[1]}")
    private String subject;

    //读取单一数据可以解决读取数据的问题，但是如果定义的数据量过大，这么一个一个书写肯定会累死人的
    //SpringBoot提供了一个对象，能够把所有的数据都封装到这一个对象中，这个对象叫做Environment
    //使用自动装配注解可以将所有的yaml数据封装到这个对象中
    //使用自动装配将所有的数据封装到一个对象Environment中
    @Autowired
    private Environment environment;

    @Autowired
    private MyDataSource myDataSource;

    @Autowired
    private Enterprise enterprise;

    @GetMapping
    public String getId() {
        System.out.println("country = " + country);
        System.out.println("port = " + port);
        System.out.println("serverPort = " + serverPort);
        System.out.println("party = " + party);
        System.out.println("birthday = " + birthday);
        System.out.println("name = " + name);
        System.out.println("likes1 = " + likes1);
        System.out.println("likes2 = " + likes2);
        System.out.println("age1 = " + age1);
        System.out.println("tempDir = " + tempDir);
        System.out.println("tempDir2 = " + tempDir2);
        System.out.println("lesson = " + lesson);
        System.out.println("subject = " + subject);
        System.out.println("environment = " + environment.getProperty("user.name"));
        System.out.println("environment = " + environment.getProperty("server.port"));
        System.out.println("myDataSource = " + myDataSource);
        System.out.println("enterprise = " + enterprise);
        System.out.println("springboot is running...");
        return "springboot is running...";
    }
}