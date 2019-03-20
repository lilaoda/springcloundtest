package com.lhy.mybatis1.entity;


import lombok.Data;

@Data
//@Table(name = "order_info")
public class Order {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "order_num")
    private String orderNum;
//    @Column(name = "order_name")
    private String orderName;
//    @Column(name = "order_address")
    private String orderAddress;
//    @Column(name = "user_id")
    private String userId;
//    @Column(name = "goods_num")
    private String goodsNum;

}
