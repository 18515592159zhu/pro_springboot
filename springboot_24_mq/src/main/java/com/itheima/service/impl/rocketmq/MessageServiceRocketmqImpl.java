package com.itheima.service.impl.rocketmq;

import com.itheima.service.MessageService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhuchifeng
 * @Date 2022/10/27 5:11
 * @Version 1.0
 * 1. springboot整合RocketMQ使用RocketMQTemplate对象作为客户端操作消息队列
 * 2. 操作RocketMQ需要配置RocketMQ服务器地址，默认端口9876
 * 3. 企业开发时通常使用监听器来处理消息队列中的消息，设置监听器使用注解@RocketMQMessageListener
 */
//@Service
public class MessageServiceRocketmqImpl implements MessageService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列（rocketmq），id：" + id);
        //rocketMQTemplate.convertAndSend("order_id",id);
        SendCallback callback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功");
            }

            @Override
            public void onException(Throwable e) {
                System.out.println("消息发送失败！！！！！");
            }
        };
        rocketMQTemplate.asyncSend("order_id", id, callback);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
