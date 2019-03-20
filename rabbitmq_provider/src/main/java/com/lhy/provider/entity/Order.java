package com.lhy.provider.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "order_info")
public class Order implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_num")
    private String orderNum;
    @Column(name = "order_name")
    private String orderName;
    @Column(name = "order_address")
    private String orderAddress;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "goods_num")
    private String goodsNum;

}
