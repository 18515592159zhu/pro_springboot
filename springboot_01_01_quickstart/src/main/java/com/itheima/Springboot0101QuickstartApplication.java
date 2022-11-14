package com.itheima;

import com.itheima.controller.BookController;
import com.itheima.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author zhuchifeng
 * @Date 2022/10/23 5:55
 * @Version 1.0
 */
@SpringBootApplication
public class Springboot0101QuickstartApplication {
    public static void main(String[] args) {
        //ConfigurableApplicationContext：它在ApplicationContext的基础上增加了一系列配置应用上下文的功能，即可配置的容器对象
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot0101QuickstartApplication.class, args);
        BookController bean = ctx.getBean(BookController.class);
        System.out.println("bean======>" + bean);
        User user = ctx.getBean(User.class);
        System.out.println(user);
    }
}