package com.example.demo.service.jpa;

import com.example.demo.controller.vue.jpa.request.MemberRequest;
import com.example.demo.controller.vue.jpa.request.SignInForm;
import com.example.demo.entity.jpa.Member;

import java.util.Optional;

public interface AccountService {
    public void register(SignInForm form) throws Exception;
}