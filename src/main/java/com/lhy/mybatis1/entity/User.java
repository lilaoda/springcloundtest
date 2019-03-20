package com.lhy.mybatis1.entity;


import lombok.Data;

import javax.validation.constraints.Max;
import java.io.Serializable;

@Data
//@Table(name = "user")
public class User implements Serializable{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Max(value = 99,message = "年龄最大不能超过99")
    private int age;
    private String account;
    private String password;
    private String sex;
    private String token;

}
