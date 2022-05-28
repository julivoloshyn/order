package com.task.order.dto;

public class OrderDTO {

    private double price;
    private int quantity;
    private String item;

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItem() {
        return item;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
