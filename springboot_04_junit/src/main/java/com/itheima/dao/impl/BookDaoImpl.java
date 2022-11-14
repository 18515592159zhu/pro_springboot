package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @Author zhuchifeng
 * @Date 2022/10/23 8:57
 * @Version 1.0
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("bookDao is ruunning...");
    }
}
