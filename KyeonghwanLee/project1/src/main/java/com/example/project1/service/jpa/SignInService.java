package com.example.project1.service.jpa;

import com.example.project1.controller.jpa.request.SignInForm;

public interface SignInService {

    Boolean signIn(SignInForm form);
}
