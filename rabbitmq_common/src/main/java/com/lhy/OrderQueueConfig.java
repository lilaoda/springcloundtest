package com.lhy;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OrderQueueConfig {

    /**
     * 配置路由交换对象实例
     *
     * @return
     */
    @Bean
    public DirectExchange orderDirectExchange() {
        return new DirectExchange(ExchangeEnum.RABBITMQ_TEST.getValue());
    }

    /**
     * 配置用户注册队列对象实例
     * 并设置持久化队列
     *
     * @return
     */
    @Bean
    public Queue orderQueue() {
        return new Queue(QueueEnum.RABBITMQ_TEST.getName(), true);
    }

    /**
     * 将队列绑定到路由交换配置上并设置指定路由键进行转发
     *
     * @return
     */
    @Bean
    public Binding orderBinding() {
        return BindingBuilder.bind(orderQueue()).to(orderDirectExchange()).with(QueueEnum.RABBITMQ_TEST.getRoutingKey());
    }

}

