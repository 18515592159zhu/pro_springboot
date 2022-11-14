package com.itheima.dao;

import com.itheima.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author zhuchifeng
 * @Date 2022/10/23 9:24
 * @Version 1.0
 */
@Mapper
public interface BookDao {
    @Select("select * from tbl_book where id = #{id}")
    public Book getById(Integer id);
}
