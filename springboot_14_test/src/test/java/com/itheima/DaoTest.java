package com.itheima;


import com.itheima.pojo.Book;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author zhuchifeng
 * @Date 2022/10/25 14:38
 * @Version 1.0
 * 在springboot的测试类中通过添加注解@Transactional来阻止测试用例提交事务
 * 通过注解@Rollback控制springboot测试类执行结果是否提交事务，需要配合注解@Transactional使用
 */
@SpringBootTest
@Transactional
@Rollback(false)
public class DaoTest {
    @Autowired
    private BookService bookService;

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("springboot3");
        book.setType("springboot3");
        book.setDescription("springboot3");

        bookService.save(book);
    }
}
