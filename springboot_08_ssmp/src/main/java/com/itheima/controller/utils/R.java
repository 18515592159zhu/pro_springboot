package com.itheima.controller.utils;

import lombok.Data;

/**
 * @Author zhuchifeng
 * @Date 2022/10/24 6:38
 * @Version 1.0
 */
//表现层消息一致性处理
@Data
public class R {

    //flag用于标识操作是否成功
    private Boolean flag;
    //data用于封装操作数据
    private Object data;

    //用于封装消息
    private String msg;

    public R() {
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Object data) {
        this.data = data;
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }
}