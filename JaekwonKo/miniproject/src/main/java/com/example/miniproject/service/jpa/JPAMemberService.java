package com.example.miniproject.service.jpa;

import com.example.miniproject.controller.vue.jpa.request.MemberRequest;
import com.example.miniproject.entity.jpa.Member;

import java.util.Optional;

public interface JPAMemberService {
    public void register(MemberRequest memberRequest) throws Exception;

    public boolean login(MemberRequest memberRequest) throws Exception;

    public boolean checkUserIdValidation(String userId) throws Exception;


    public Optional<Member> findByAuth(Long memberNo);
}