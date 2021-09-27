package com.example.foodfood.service.jpa;

import com.example.foodfood.controller.vue.jpa.request.SignInForm;

public interface SignInService {

    Boolean signIn(SignInForm form);
}