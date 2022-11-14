package com.itheima.service;

import com.itheima.pojo.Book;

import java.util.List;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 8:36
 * @Version 1.0
 */
public interface BookService {
    public boolean save(Book book);

    public Book getById(Integer id);

    public boolean update(Book book);

    public boolean delete(Integer id);

    public List<Book> getAll();
}
