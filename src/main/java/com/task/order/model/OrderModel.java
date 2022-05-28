package com.task.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderModel {

    @Id
    @GeneratedValue
    private String orderId;
    private double price;
    private int quantity;
    private String item;
}
