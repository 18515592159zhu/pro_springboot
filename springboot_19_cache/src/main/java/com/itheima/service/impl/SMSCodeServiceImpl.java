package com.itheima.service.impl;

import com.itheima.pojo.SMSCode;
import com.itheima.service.SMSCodeService;
import com.itheima.utils.CodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 8:05
 * @Version 1.0
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

//    @CachePut(value = "smsCode", key = "#tele")
//    public String sendCodeToSMS(String tele) {
//        String code = codeUtils.generator(tele);
//        return code;
//    }
//
//    public boolean checkCode(SMSCode smsCode) {
//        //取出内存中的验证码与传递过来的验证码比对，如果相同，返回true
//        String code = smsCode.getCode();
//        String cacheCode = codeUtils.get(smsCode.getTele());
//        return code.equals(cacheCode);
//    }


    //以下是springboot中使用xmemcached
    @Autowired
    private MemcachedClient memcachedClient;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        try {
            memcachedClient.set(tele, 10, code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = null;
        try {
            code = memcachedClient.get(smsCode.getTele()).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smsCode.getCode().equals(code);
    }
}