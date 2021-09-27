package com.example.project1.service.jpa;


import com.example.project1.controller.jpa.request.MemberRequest;
import com.example.project1.controller.jpa.request.SignInForm;
import com.example.project1.entity.jpa.PrMember;

import java.util.Optional;

public interface AccountService {
    public void register(SignInForm form) throws Exception;
}