package com.itheima.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 8:33
 * @Version 1.0
 */
@Data
public class Book implements Serializable {
    private Integer id;
    private String type;
    private String name;
    private String description;
}