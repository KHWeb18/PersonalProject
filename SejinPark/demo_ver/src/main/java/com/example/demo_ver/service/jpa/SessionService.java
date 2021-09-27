package com.example.demo_ver.service.jpa;

import com.example.demo_ver.controller.vue.jpa.request.SaveUserRequest;

public interface SessionService {
    void save(SaveUserRequest request);
    void logout();
    // Object get(SessionKey key);
}