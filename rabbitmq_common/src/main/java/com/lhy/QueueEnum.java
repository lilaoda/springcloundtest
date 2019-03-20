package com.lhy;

import lombok.Getter;

@Getter
public enum QueueEnum {
    RABBITMQ_TEST("order.msg.queue", "order.msg");
    private String name;
    private String routingKey;

    QueueEnum(String name, String routingKey) {
        this.name = name;
        this.routingKey = routingKey;
    }
}
