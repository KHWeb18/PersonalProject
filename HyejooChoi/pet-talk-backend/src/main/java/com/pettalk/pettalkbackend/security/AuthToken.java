package com.pettalk.pettalkbackend.security;

public interface AuthToken<T> {
    boolean validate();
    T getData();
}
