package com.example.foodfood.service.jpa;

import com.example.foodfood.controller.vue.jpa.request.SaveUserRequest;

public interface SessionService {
    void save(SaveUserRequest request);
    void logout();
    // Object get(SessionKey key);
}