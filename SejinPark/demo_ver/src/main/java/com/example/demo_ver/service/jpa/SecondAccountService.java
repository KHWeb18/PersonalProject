package com.example.demo_ver.service.jpa;

import com.example.demo_ver.controller.vue.jpa.request.SignInForm;

public interface SecondAccountService {
    public void register(SignInForm form) throws Exception;
}