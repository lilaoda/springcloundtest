package com.lhy.mybatis1.mapper;

import com.lhy.mybatis1.entity.User;
import com.lhy.mybatis1.utils.CommonMapper;
import com.lhy.mybatis1.vo.OrderDetail;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends CommonMapper<User> {

    OrderDetail findOrderByUserId(long id);

}
