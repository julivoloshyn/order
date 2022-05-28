package com.task.order.controller;

import com.task.order.dto.OrderDTO;
import com.task.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public void saveOrder(@RequestBody OrderDTO orderDTO) {
        orderService.saveOrder(orderDTO);
    }
}
