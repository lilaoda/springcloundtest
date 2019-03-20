package com.lhy.provider.event;

import com.lhy.ExchangeEnum;
import com.lhy.QueueEnum;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class QueueMsgServiceSupport implements QueueMsgService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Object object){
        rabbitTemplate.setConfirmCallback(this);
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(ExchangeEnum.RABBITMQ_TEST.getValue(), QueueEnum.RABBITMQ_TEST.getRoutingKey(),"99999999999",correlationId);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println(" 回调id:" + correlationData.getId());
        if (ack) {
            System.out.println("消息发送成功");
        } else {
            System.out.println("消息发送失败:" + cause);
        }
    }
}
