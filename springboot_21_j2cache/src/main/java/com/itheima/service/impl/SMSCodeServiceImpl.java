package com.itheima.service.impl;

import com.itheima.pojo.SMSCode;
import com.itheima.service.SMSCodeService;
import com.itheima.utils.CodeUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 8:49
 * @Version 1.0
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    @Autowired
    private CacheChannel cacheChannel;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        cacheChannel.set("sms", tele, code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = cacheChannel.get("sms", smsCode.getTele()).asString();
        return smsCode.getCode().equals(code);
    }
}