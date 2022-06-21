package com.task.order.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userorder")
public class OrderModel {

    @Id
    @GeneratedValue (generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String orderId;
    private double price;
    private int quantity;
    private String item;

    public OrderModel(String orderId, double price, int quantity, String item) {
        this.orderId = orderId;
        this.price = price;
        this.quantity = quantity;
        this.item = item;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
