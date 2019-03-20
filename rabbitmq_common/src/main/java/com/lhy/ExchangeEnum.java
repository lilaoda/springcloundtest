package com.lhy;

import lombok.Getter;

@Getter
public enum  ExchangeEnum {

    RABBITMQ_TEST("rabbitmq.test")
    ;
    private String value;

    ExchangeEnum(String value) {
        this.value = value;
    }
}
