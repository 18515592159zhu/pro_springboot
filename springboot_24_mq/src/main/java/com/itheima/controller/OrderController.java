package com.itheima.controller;

import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 13:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //表现层对外开发接口，传入订单id即可（模拟）
    @PostMapping("{id}")
    public void order(@PathVariable String id) {
        orderService.order(id);
    }
}
