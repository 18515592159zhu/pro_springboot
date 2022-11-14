package com.itheima.service.impl;

import com.itheima.service.MsgService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 8:23
 * @Version 1.0
 */
@Service
public class MsgServiceImpl implements MsgService {

    private HashMap<String, String> cache = new HashMap<String, String>();

    @Override
    public String get(String tele) {
        String code = tele.substring(tele.length() - 6);
        cache.put(tele, code);
        return code;
    }

    @Override
    public boolean check(String tele, String code) {
        String queryCode = cache.get(tele);
        return code.equals(queryCode);
    }
}
