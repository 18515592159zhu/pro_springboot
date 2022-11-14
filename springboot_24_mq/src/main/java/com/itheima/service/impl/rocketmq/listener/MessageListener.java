package com.itheima.service.impl.rocketmq.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Author zhuchifeng
 * @Date 2022/10/27 5:13
 * @Version 1.0
 * RocketMQ的监听器必须按照标准格式开发，实现RocketMQListener接口，泛型为消息类型。
 * 使用注解@RocketMQMessageListener定义当前类监听RabbitMQ中指定组、指定名称的消息队列。
 */
//@Component
@RocketMQMessageListener(topic = "order_id", consumerGroup = "group_rocketmq")
public class MessageListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String id) {
        System.out.println("已完成短信发送业务(rocketmq)，id：" + id);
    }
}