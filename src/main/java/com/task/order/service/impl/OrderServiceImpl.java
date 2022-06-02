package com.task.order.service.impl;

import com.task.order.dto.OrderDTO;
import com.task.order.model.OrderModel;
import com.task.order.repository.OrderRepository;
import com.task.order.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{


    OrderRepository orderRepository;
    ModelMapper mapper = new ModelMapper();

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        OrderModel orderModel = mapper.map(orderDTO, OrderModel.class);

        return mapper.map(
                orderRepository.save(orderModel), OrderDTO.class);
    }

    @Override
    public List<OrderDTO> findOrderByItem(String orderItem) {

        List<OrderModel> orders = orderRepository.findByItem(orderItem);
        orders.sort(Comparator.comparing(OrderModel::getPrice));

        if(orders.isEmpty() || orders.get(0).getQuantity() == 0) {
            return orderRepository.findAll()
                    .stream()
                    .map(
                            orderModel1 -> mapper.map(orderModel1, OrderDTO.class))
                    .collect(Collectors.toList());
        }

        OrderModel order = orders.get(0);
        order.setQuantity(order.getQuantity() - 1);

        orderRepository.save(order);

        return Collections.singletonList(mapper.map(order, OrderDTO.class));
    }

    @Override
    public OrderDTO deleteOrder(OrderDTO orderDTO) {
        return null;
    }
}
