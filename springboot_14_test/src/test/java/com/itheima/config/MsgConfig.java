package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhuchifeng
 * @Date 2022/10/25 6:46
 * @Version 1.0
 */
@Configuration
public class MsgConfig {
    @Bean
    public String msg() {
        return "bean msg";
    }
}
