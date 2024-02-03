package com.example.orderservice.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import com.example.orderservice.model.Order;
import com.example.orderservice.service.DeliveryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
    private static final ObjectMapper mapper = new ObjectMapper();
    private final DeliveryService deliveryService = new DeliveryService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        StringBuilder requestBody = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonData = requestBody.toString();
        Order order = mapper.readValue(jsonData, Order.class);
        int code = deliveryService.makeDelivery(order);
        if (code == 200 || code == 201) {
            response.getWriter().println("Order successfully created!");
        }
    }

}