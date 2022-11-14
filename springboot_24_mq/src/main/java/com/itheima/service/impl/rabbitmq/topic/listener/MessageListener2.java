package com.itheima.service.impl.rabbitmq.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @Author zhuchifeng
 * @Date 2022/10/27 5:21
 * @Version 1.0
 */
//@Component
public class MessageListener2 {

    @RabbitListener(queues = "topic_queue")
    public void receive(String id) {
        System.out.println("已完成短信发送业务(rabbitmq topic one)，id：" + id);
    }

    @RabbitListener(queues = "topic_queue2")
    public void receive2(String id) {
        System.out.println("已完成短信发送业务(rabbitmq topic two)，id：" + id);
    }
}