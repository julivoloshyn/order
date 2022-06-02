package com.task.order.service;

import com.task.order.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    OrderDTO saveOrder(OrderDTO orderDTO);
    List<OrderDTO> findOrderByItem(String orderItem);
    OrderDTO deleteOrder(OrderDTO orderDTO);
}
