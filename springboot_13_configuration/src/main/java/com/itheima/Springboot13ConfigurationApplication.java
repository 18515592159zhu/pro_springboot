package com.itheima;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

//当使用@EnableConfigurationProperties声明进行属性绑定的bean后，无需使用@Component注解再次进行bean声明
@SpringBootApplication
@EnableConfigurationProperties(ServerConfig.class)
public class Springboot13ConfigurationApplication {

    //使用@ConfigurationProperties可以为使用@Bean声明的第三方bean绑定属性
    @Bean
    @ConfigurationProperties(prefix = "datasource")//绑定前缀名命名规范：仅能使用纯小写字母、数字、下划线作为合法的字符
    public DruidDataSource datasource() {
        DruidDataSource dataSource = new DruidDataSource();
        //dataSource.setDriverClassName("com.mysql.jdbc.Driver123");
        return dataSource;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot13ConfigurationApplication.class, args);
        ServerConfig bean = ctx.getBean(ServerConfig.class);
        System.out.println(bean);
        DruidDataSource ds = ctx.getBean(DruidDataSource.class);
        System.out.println(ds.getDriverClassName());
    }
}