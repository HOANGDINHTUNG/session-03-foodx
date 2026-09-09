package com.service.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public Map<String, Object> createOrder(@RequestBody Map<String, Object> orderRequest) {
        int restaurantId = (int) orderRequest.get("restaurantId");
        
        String restaurantUrl = "http://restaurant-service/api/restaurants/" + restaurantId;
        Map restaurantInfo = restTemplate.getForObject(restaurantUrl, Map.class);

        Map<String, Object> response = new HashMap<>();
        response.put("orderId", UUID.randomUUID().toString());
        response.put("status", "CREATED");
        response.put("restaurant_info", restaurantInfo);
        response.put("item_ordered", orderRequest.get("item"));
        return response;
    }
}
