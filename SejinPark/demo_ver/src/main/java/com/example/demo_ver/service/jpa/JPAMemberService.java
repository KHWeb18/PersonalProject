package com.example.demo_ver.service.jpa;

import com.example.demo_ver.controller.vue.jpa.request.MemberRequest;
import com.example.demo_ver.entity.jpa.Member;

import java.util.Optional;

public interface JPAMemberService {
    public void register(MemberRequest memberRequest) throws Exception;

    public boolean login(MemberRequest memberRequest) throws Exception;
    public boolean checkUserIdValidation(String userId) throws Exception;


    public Optional<Member> findByAuth(Long memberNo);
}