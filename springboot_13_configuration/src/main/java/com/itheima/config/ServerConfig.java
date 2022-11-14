package com.itheima.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.util.unit.DataSize;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @Author zhuchifeng
 * @Date 2022/10/25 6:12
 * @Version 1.0
 * 使用@ConfigurationProperties可以为使用@Bean声明的第三方bean绑定属性
 * 当使用@EnableConfigurationProperties声明进行属性绑定的bean后，无需使用@Component注解再次进行bean声明
 */
//@Component
@Data
@ConfigurationProperties(prefix = "servers")
//2.开启对当前bean的属性注入校验
@Validated
public class ServerConfig {
    private String ipAddress;
    //3.设置具体的规则
    @Max(value = 8888, message = "最大值不能超过8888")
    @Min(value = 202, message = "最小值不能低于202")
    private int port;
    private long timeout;

    //Duration表示时间间隔，可以通过@DurationUnit注解描述时间单位
    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeOut;

    //DataSize表示存储空间，可以通过@DataSizeUnit注解描述存储空间单位
    //@DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;

    private Host host;
}
