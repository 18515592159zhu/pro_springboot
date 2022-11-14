package com.itheima.service.impl.kafka;

import com.itheima.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author zhuchifeng
 * @Date 2022/10/27 5:07
 * @Version 1.0
 * 1. springboot整合Kafka使用KafkaTemplate对象作为客户端操作消息队列
 * 2. 操作Kafka需要配置Kafka服务器地址，默认端口9092
 * 3. 企业开发时通常使用监听器来处理消息队列中的消息，设置监听器使用注解@KafkaListener。接收消息保存在形参ConsumerRecord对象中
 */
@Service
public class MessageServiceKafkaImpl implements MessageService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列（kafka），id：" + id);
        kafkaTemplate.send("itheima2022", id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}