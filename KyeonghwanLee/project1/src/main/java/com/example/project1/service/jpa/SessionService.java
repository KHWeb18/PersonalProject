package com.example.project1.service.jpa;


import com.example.project1.controller.jpa.request.SaveUserRequest;
import com.example.project1.controller.jpa.request.SessionKey;

public interface SessionService {
    void save(SaveUserRequest request);
    void logout();
    // Object get(SessionKey key);
}
