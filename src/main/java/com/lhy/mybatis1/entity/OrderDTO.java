package com.lhy.mybatis1.entity;

import lombok.Data;

@Data
public class OrderDTO {
    private String userName;
    private int userAge;
    private String userId;
    private String orderNum;
    private String orderName;
    private String orderAddress;
}
