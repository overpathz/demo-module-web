package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*
External service
 */
public class DeliveryService {
    // post http
    private static final String API_URL = "http://localhost:8082/delivery";
    private static final HttpClient httpClient = HttpClient.newBuilder().build();
    private static final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    public int makeDelivery(Order order) {
        String jsonOrder = mapper.writeValueAsString(order);
        HttpRequest postRequest = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(jsonOrder))
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> send = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        return send.statusCode();
    }
}
