package com.example.demo.service.jpa;

import com.example.demo.controller.vue.jpa.request.SaveUserRequest;
import com.example.demo.controller.vue.jpa.request.SessionKey;

public interface SessionService {
    void save(SaveUserRequest request);
    void logout();
    // Object get(SessionKey key);
}