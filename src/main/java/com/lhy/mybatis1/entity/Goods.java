package com.lhy.mybatis1.entity;

import lombok.Data;

@Data
//@Table(name = "goods")
public class Goods {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "goods_num")
    private String goodsNum;
//    @Column(name = "goods_name")
    private String goodsName;
}
