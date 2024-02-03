package com.example.deliveryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
delivery time
ukr, novaposchta, no, user, city, country
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {
    private String email;
    private int estimatedDays;
}
