package com.lhy.mybatis1.service;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface BaseService<T> {

    List<T> select(T t);

    List<T> selectAll();

    int insert(T t);

    int updateByPrimaryKey(T t);

     int deleteByPrimaryKey(T t );

    List<T> selectByExample(Example example);
}
