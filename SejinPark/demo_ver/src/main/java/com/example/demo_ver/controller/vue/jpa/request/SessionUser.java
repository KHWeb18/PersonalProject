package com.example.demo_ver.controller.vue.jpa.request;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String email;

    public SessionUser(String email) {
        this.email = email;
    }
}