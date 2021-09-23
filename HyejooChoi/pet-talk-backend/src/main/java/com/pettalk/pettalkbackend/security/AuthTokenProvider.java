package com.pettalk.pettalkbackend.security;

import com.pettalk.pettalkbackend.entity.User;

import java.util.Date;

public interface AuthTokenProvider<T> {
    T createAuthToken(User user, String role);
    T convertAuthToken(String token);
}