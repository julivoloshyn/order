package com.task.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDTO {

    @JsonProperty("price")
    private double price;
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("item")
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

    public OrderDTO(double price, int quantity, String item) {
        this.price = price;
        this.quantity = quantity;
        this.item = item;
    }
}
