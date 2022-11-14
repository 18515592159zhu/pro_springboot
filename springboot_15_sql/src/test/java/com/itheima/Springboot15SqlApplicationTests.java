package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 0:59
 * @Version 1.0
 */
@SpringBootTest
public class Springboot15SqlApplicationTests {

    @Autowired
    private BookDao bookDao;

    //SpringBoot内置JdbcTemplate持久化解决方案
    //使用JdbcTemplate需要导入spring-boot-starter-jdbc的坐标
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void test() {
        bookDao.selectById(1);
    }

    //使用JdbcTemplate实现查询操作（非实体类封装数据的查询操作）
    @Test
    void testJdbcTemplate() {
        String sql = "select * from tbl_book";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(System.out::println);
    }

    //使用JdbcTemplate实现查询操作（实体类封装数据的查询操作）
    @Test
    void testJdbcTemplate1() {

        String sql = "select * from tbl_book";
        RowMapper<Book> rm = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book temp = new Book();
                temp.setId(rs.getInt("id"));
                temp.setName(rs.getString("name"));
                temp.setType(rs.getString("type"));
                temp.setDescription(rs.getString("description"));
                return temp;
            }
        };
        List<Book> list = jdbcTemplate.query(sql, rm);
        list.forEach(System.out::println);
    }

    @Test
    void testJdbcTemplateSave(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "insert into tbl_book values(3,'springboot1','springboot2','springboot3')";
        jdbcTemplate.update(sql);
    }
}
