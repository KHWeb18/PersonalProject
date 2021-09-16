package com.example.demo_ver.service.jpa;

import com.example.demo_ver.controller.vue.jpa.request.SignInForm;

public interface SignInService {

    Boolean signIn(SignInForm form);
}