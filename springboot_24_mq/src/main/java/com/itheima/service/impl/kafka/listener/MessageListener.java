package com.itheima.service.impl.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author zhuchifeng
 * @Date 2022/10/27 5:09
 * @Version 1.0
 */
@Component
public class MessageListener {
    @KafkaListener(topics = "itheima2022")
    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.println("已完成短信发送业务(kafka)，id：" + record.value());
    }
}
