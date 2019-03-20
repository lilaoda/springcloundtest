package com.lhy.mybatis1.service;

import com.lhy.mybatis1.vo.ApiResult;
import com.lhy.mybatis1.vo.LoginInfo;
import com.lhy.mybatis1.vo.OrderDetail;


public interface UserService {

    OrderDetail findOrderByUserId(long id);

    ApiResult selectAll();

    ApiResult login( LoginInfo loginInfo);
}
