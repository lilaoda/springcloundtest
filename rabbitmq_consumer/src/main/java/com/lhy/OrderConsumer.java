package com.lhy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "order.msg.queue")
public class OrderConsumer {

    private Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitHandler
    public void excute(Object object){
        logger.info("收到消息:"+object);
    }
}
