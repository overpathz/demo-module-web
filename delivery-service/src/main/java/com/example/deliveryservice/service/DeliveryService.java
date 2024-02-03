package com.example.deliveryservice.service;

import com.example.deliveryservice.model.Delivery;
import com.example.deliveryservice.model.Order;

public class DeliveryService {
    private final MailService mailService = new MailService();

    public void makeDelivery(Order order) {
        String userOrderDeliveryAddress = order.getAddress();
        // calculating
        Delivery delivery = new Delivery("overpathz@gmail.com", 2);
        executeDelivery(delivery);
    }

    private void executeDelivery(Delivery delivery) {
        System.out.println("Executing delivery");
        // ...
        mailService.sendEmail(delivery.getEmail(), "Ваша доставка буде відправлена через " + delivery.getEstimatedDays());
    }
}
