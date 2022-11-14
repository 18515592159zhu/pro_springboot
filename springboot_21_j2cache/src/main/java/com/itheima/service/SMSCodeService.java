package com.itheima.service;

import com.itheima.pojo.SMSCode;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 8:49
 * @Version 1.0
 */
public interface SMSCodeService {
    public String sendCodeToSMS(String tele);

    public boolean checkCode(SMSCode smsCode);
}
