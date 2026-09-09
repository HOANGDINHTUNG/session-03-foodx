package com.service.restaurantservice;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @GetMapping
    public List<Map<String, Object>> getRestaurants() {
        return Arrays.asList(
            Map.of("id", 1, "name", "KFC", "address", "Quan 1"),
            Map.of("id", 2, "name", "Lotteria", "address", "Quan 2"),
            Map.of("id", 3, "name", "McDonalds", "address", "Quan 3")
        );
    }

    @GetMapping("/{id}")
    public Map<String, Object> getRestaurantById(@PathVariable int id) {
        return Map.of("id", id, "name", "Nha hang " + id, "address", "Dia chi " + id);
    }
}
