package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.pojo.Book;

import java.util.List;

/**
 * @Author zhuchifeng
 * @Date 2022/10/23 22:51
 * @Version 1.0
 */
public interface BookService {

    Boolean save(Book book);

    Boolean update(Book book);

    Boolean delete(Integer id);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book> getPage(int currentPage, int pageSize);
}