package com.lhy.provider.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface QueueMsgService extends RabbitTemplate.ConfirmCallback {

    //public void send(Object message, ExchangeEnum exchangeEnum, QueueEnum queueEnum) throws Exception;

}
