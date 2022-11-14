package com.itheima.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 13:41
 * @Version 1.0
 */
//@Component
public class MessageListener {

    @JmsListener(destination = "order.queue.id")
    @SendTo("order.other.queue.id")
    public String receive(String id) {
        System.out.println("已完成短信发送业务，id：" + id);
        return "new:" + id;
    }
}