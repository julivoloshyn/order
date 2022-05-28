package com.task.order.service;

import com.task.order.dto.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    OrderDTO saveOrder(OrderDTO orderDTO);
    OrderDTO findOrderByItem(String orderItem); // ?
    OrderDTO deleteOrder(OrderDTO orderDTO);
}
