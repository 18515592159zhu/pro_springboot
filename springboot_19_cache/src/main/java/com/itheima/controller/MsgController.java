package com.itheima.controller;

import com.itheima.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 8:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    private MsgService msgService;

    @GetMapping("{tele}")
    public String get(@PathVariable String tele) {
        return msgService.get(tele);
    }

    @PostMapping
    public boolean check(String tele, String code) {
        return msgService.check(tele, code);
    }
}
