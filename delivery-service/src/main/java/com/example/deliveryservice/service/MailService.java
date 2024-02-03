package com.example.deliveryservice.service;

import com.example.deliveryservice.model.Email;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MailService {
    private static final String API_URL = "http://localhost:8083/email";
    private static final HttpClient httpClient = HttpClient.newBuilder().build();
    private static final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    public void sendEmail(String email, String text) {
        Email emailToSend = new Email(email, text);
        String jsonOrder = mapper.writeValueAsString(emailToSend);
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .POST(HttpRequest.BodyPublishers.ofString(jsonOrder))
                .build();

        HttpResponse<String> send = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
    }
}
