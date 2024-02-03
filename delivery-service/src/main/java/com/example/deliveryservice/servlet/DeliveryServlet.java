package com.example.deliveryservice.servlet;

import java.io.*;

import com.example.deliveryservice.model.Order;
import com.example.deliveryservice.service.DeliveryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/delivery")
public class DeliveryServlet extends HttpServlet {
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
        deliveryService.makeDelivery(order);
        response.setStatus(200);
        response.getWriter().println("Order will be delivered soon!");
    }
}