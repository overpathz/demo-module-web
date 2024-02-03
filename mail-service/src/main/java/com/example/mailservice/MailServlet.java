package com.example.mailservice;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/email")
public class MailServlet extends HttpServlet {
    private static final ObjectMapper mapper = new ObjectMapper();

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
        Email userEmail = mapper.readValue(jsonData, Email.class);

        System.out.println("Email has been sent to "+ userEmail.getEmail() + " with text: " + userEmail.getText());

        response.setStatus(200);
        response.getWriter().println("Order will be delivered soon!");
    }
}