package com.itheima.dao;

import com.itheima.pojo.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 0:58
 * @Version 1.0
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {

}