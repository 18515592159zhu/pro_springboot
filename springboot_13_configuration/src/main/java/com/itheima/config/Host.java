package com.itheima.config;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @Author zhuchifeng
 * @Date 2022/10/25 6:10
 * @Version 1.0
 */
@Data
public class Host {
    private String ipAddress;
    @Max(value = 8888, message = "最大值不能超过8888")
    @Min(value = 202, message = "最小值不能低于202")
    private int port;
}
