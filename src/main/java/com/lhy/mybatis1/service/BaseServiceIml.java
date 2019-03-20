package com.lhy.mybatis1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


public abstract class BaseServiceIml<T> implements BaseService<T> {

    public abstract Mapper<T> getMapper();

    public List<T> select(T t) {
        return getMapper().select(t);
    }

    public List<T> selectAll() {
        return getMapper().selectAll();
    }

    @Override
    public int insert(T t) {
        return getMapper().insert(t);
    }

    public int updateByPrimaryKey(T t) {
        return getMapper().updateByPrimaryKey(t);
    }

    @Override
    public int deleteByPrimaryKey(T t) {
        return getMapper().deleteByPrimaryKey(t);
    }

    public List<T> selectByExample(Example example) {
        return getMapper().selectByExample(example);
    }

}
