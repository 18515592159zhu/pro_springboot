package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.pojo.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zhuchifeng
 * @Date 2022/10/23 23:07
 * @Version 1.0
 * 表现层消息一致性处理
 */
//@RestController
@RequestMapping("/books")
public class BookController1 {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new R(flag);
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        boolean flag = bookService.modify(book);
        return new R(flag);
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new R(flag);
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        return new R(true, book);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        return new R(true, page);
    }

    /**
     * 总结
     * 1. 设计统一的返回值结果类型便于前端开发读取数据
     * 2. 返回值结果类型可以根据需求自行设定，没有固定格式
     * 3. 返回值结果模型类用于后端与前端进行数据格式统一，也称为前后端数据协议
     */
}