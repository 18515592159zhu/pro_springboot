package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author zhuchifeng
 * @Date 2022/10/23 18:04
 * @Version 1.0
 */
@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    public void testSave() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
    }

    @Test
    public void testUpdate() {
        Book book = new Book();
        book.setId(53);
        book.setType("测试数据abcdefg");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.updateById(book);
    }

    @Test
    public void testDelete() {
        bookDao.deleteById(53);
    }

    @Test
    public void testGetAll() {
        bookDao.selectList(null);
    }

    //定义MP拦截器并将其设置为Spring管控的bean
    @Test
    void testGetPage() {
        IPage page = new Page(1, 3);
        bookDao.selectPage(page, null);
        System.out.println("当前页码值：" + page.getCurrent());
        System.out.println("每页显示几条数据：" + page.getSize());
        System.out.println("数据总量：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("详细数据：" + page.getRecords());
    }

    //条件查询功能制作：模糊匹配对应的操作
    @Test
    public void testGetByLikes() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "Spring");
        bookDao.selectList(queryWrapper);
    }

    //MP针对字段检查进行了功能升级，全面支持Lambda表达式
    @Test
    public void testGetByLikes2() {
        String name = "spring";
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<Book>();
        //if (name != null) lambdaQueryWrapper.like(Book::getName, name);
        lambdaQueryWrapper.like(Book::getName, name);
        bookDao.selectList(lambdaQueryWrapper);
    }

    //为了便于开发者动态拼写SQL，防止将null数据作为条件使用，MP还提供了动态拼装SQL的快捷书写方式
    @Test
    void testGetByLikes3() {
        String name = "spring";
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<Book>();
        //if (name != null) lambdaQueryWrapper.like(Book::getName, name);        //方式一：JAVA代码控制
        lambdaQueryWrapper.like(name != null, Book::getName, name);    //方式二：API接口提供控制开关
        bookDao.selectList(lambdaQueryWrapper);
    }

    /**
     * 1. 使用QueryWrapper对象封装查询条件
     * 2. 推荐使用LambdaQueryWrapper对象
     * 3. 所有查询操作封装成方法调用
     * 4. 查询条件支持动态条件拼装
     */
}
