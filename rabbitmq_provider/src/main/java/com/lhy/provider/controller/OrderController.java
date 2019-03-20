package com.lhy.provider.controller;

import com.lhy.provider.entity.Order;
import com.lhy.provider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "order/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/save")
    public Order save(Order order) throws Exception
    {
        orderService.save(order);
        return order;
    }
}
