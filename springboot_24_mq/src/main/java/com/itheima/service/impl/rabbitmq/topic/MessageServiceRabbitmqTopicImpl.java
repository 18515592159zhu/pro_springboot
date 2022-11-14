package com.itheima.service.impl.rabbitmq.topic;

import com.itheima.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author zhuchifeng
 * @Date 2022/10/27 5:16
 * @Version 1.0
 * 1. springboot整合RabbitMQ提供了AmqpTemplate对象作为客户端操作消息队列
 * 2. 操作ActiveMQ需要配置ActiveMQ服务器地址，默认端口5672
 * 3. 企业开发时通常使用监听器来处理消息队列中的消息，设置监听器使用注解@RabbitListener
 * 4. RabbitMQ有5种消息模型，使用的队列相同，但是交换机不同。交换机不同，对应的消息进入的策略也不同
 */
//@Service
public class MessageServiceRabbitmqTopicImpl implements MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列（rabbitmq topic），id：" + id);
        amqpTemplate.convertAndSend("topicExchange", "topic.orders.id", id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
