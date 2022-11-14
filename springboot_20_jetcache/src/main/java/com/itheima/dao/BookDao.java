package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 8:35
 * @Version 1.0
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
