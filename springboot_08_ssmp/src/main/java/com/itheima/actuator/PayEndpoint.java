package com.itheima.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhuchifeng
 * @Date 2022/11/9 17:49
 * @Version 1.0
 */

@Component
@Endpoint(id = "pay", enableByDefault = true)
public class PayEndpoint {
    @ReadOperation
    public Object getPay() {
        Map payMap = new HashMap();
        payMap.put("level 1", "300");
        payMap.put("level 2", "291");
        payMap.put("level 3", "666");
        return payMap;
    }
}
