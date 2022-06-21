package com.task.order.controller;

import com.task.order.dto.OrderDTO;
import com.task.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/request-item")
public class RequestItemController {

    private final OrderService orderService;

    public RequestItemController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/get-order/{item}")
    public ResponseEntity<List<OrderDTO>> getOrder(@PathVariable(name = "item") String orderItem) {
        return ResponseEntity.ok(orderService.findOrderByItem(orderItem));
    }

}
