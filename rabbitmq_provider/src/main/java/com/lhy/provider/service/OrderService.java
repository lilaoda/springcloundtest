package com.lhy.provider.service;

import com.lhy.provider.entity.Order;
import com.lhy.provider.event.QueueMsgServiceSupport;
import com.lhy.provider.jpa.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private QueueMsgServiceSupport queueMsgServiceSupport;


    public void save(Order order) {
        queueMsgServiceSupport.send(order);
        orderRepository.save(order);
    }
}
