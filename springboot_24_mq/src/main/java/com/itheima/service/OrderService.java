package com.itheima.service;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 13:15
 * @Version 1.0
 * 订单业务
 * 购物订单发送手机短信案例
 */
public interface OrderService {
    //模拟传入订单id，执行下订单业务，参数为虚拟设定，实际应为订单对应的实体类
    void order(String id);
}