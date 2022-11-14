package com.itheima.service;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 13:19
 * @Version 1.0
 * 短信处理业务
 */
public interface MessageService {

    //发送要处理的订单id到消息中间件
    void sendMessage(String id);

    //处理消息，实际消息的处理过程不应该是手动执行，应该是自动执行，到具体实现时再进行设计
    String doMessage();
}