package com.lhy.mybatis1.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginInfo {

    @NotEmpty
    private String account;
    @NotEmpty
    private String password;
}
