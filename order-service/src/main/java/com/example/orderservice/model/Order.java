package com.example.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private String orderName;
    private String username;
    private String email;
    private String address;
    private double price;

    public Order(String orderName, String username, String email, String address, double price) {
        this.orderName = orderName;
        this.username = username;
        this.email = email;
        this.address = address;
        this.price = price;
    }
}
