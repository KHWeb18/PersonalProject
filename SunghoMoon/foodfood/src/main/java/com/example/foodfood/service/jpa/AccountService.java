package com.example.foodfood.service.jpa;

import com.example.foodfood.controller.vue.jpa.request.SignInForm;

public interface AccountService {
    public void register(SignInForm form) throws Exception;
}