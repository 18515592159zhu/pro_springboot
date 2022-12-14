package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.pojo.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 8:04
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

//    private HashMap<Integer, Book> cache = new HashMap<Integer, Book>();
//
//    @Override
//    public Book getById(Integer id) {
//        //如果当前缓存中没有本次要查询的数据，则进行查询，否则直接从缓存中获取数据返回
//        Book book = cache.get(id);
//        if (book == null) {
//            book = bookDao.selectById(id);
//            cache.put(id, book);
//        }
//        return book;
//    }

    //设置操作的数据是否使用缓存
    @Cacheable(value = "cacheSpace", key = "#id")
    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
