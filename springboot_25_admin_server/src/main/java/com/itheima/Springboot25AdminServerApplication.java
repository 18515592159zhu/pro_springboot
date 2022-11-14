package com.itheima;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer//声明当前应用启动后作为SpringBootAdmin的服务器使用
public class Springboot25AdminServerApplication {

    //访问：http://localhost:8080/applications
    public static void main(String[] args) {
        SpringApplication.run(Springboot25AdminServerApplication.class, args);
    }

}
