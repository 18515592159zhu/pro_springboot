package com.itheima.controller;

import com.itheima.pojo.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zhuchifeng
 * @Date 2022/11/7 16:54
 * @Version 1.0
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("{id}")
    public Book get(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @PostMapping
    public boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping
    public boolean update(@RequestBody Book book) {
        return bookService.update(book);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) {
        return bookService.delete(id);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }
}
