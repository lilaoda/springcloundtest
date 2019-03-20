package com.lhy.mybatis1.vo;


import com.lhy.mybatis1.entity.Goods;
import com.lhy.mybatis1.entity.Order;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderDetail implements Serializable {

    private String userName;
    private int userAge;
    private String userId;
    List<Order> orders;
    Goods goods;

//    private String orderNum;
//    private String orderName;
//    private String orderAddress;
//
//    private String goodsNum;
//    private String goodsName;

}
