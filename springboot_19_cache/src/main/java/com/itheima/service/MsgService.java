package com.itheima.service;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 8:22
 * @Version 1.0
 */
public interface MsgService {
    public String get(String tele);
    public boolean check(String tele ,String code);
}
