package com.lhy.mybatis1.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 不能与其它mapper放在同一文件夹中
 * @param <T>
 */
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T>{
}
