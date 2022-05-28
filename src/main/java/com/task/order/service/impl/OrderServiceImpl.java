package com.task.order.service.impl;

import com.task.order.dto.OrderDTO;
import com.task.order.model.OrderModel;
import com.task.order.repository.OrderRepository;
import com.task.order.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    OrderRepository orderRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        OrderModel orderModel = mapper.map(orderDTO, OrderModel.class);

        return mapper.map(
                orderRepository.save(orderModel), OrderDTO.class);
    }

    @Override
    public OrderDTO findOrderByItem(String orderItem) {
        return null;
    }

    @Override
    public OrderDTO deleteOrder(OrderDTO orderDTO) {
        return null;
    }
}
