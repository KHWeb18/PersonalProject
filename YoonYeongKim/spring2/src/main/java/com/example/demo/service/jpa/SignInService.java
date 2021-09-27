package com.example.demo.service.jpa;

import com.example.demo.controller.vue.jpa.request.SignInForm;

public interface SignInService {

    Boolean signIn(SignInForm form);
}