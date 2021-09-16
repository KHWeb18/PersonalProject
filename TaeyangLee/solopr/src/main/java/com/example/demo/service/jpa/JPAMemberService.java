package com.example.demo.service.jpa;

import com.example.demo.controller.member.request.MemberRequest;
import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.MemberAuth;

import java.util.List;
import java.util.Optional;

public interface JPAMemberService {
    public void register(MemberRequest memberRequest) throws Exception;

    public MemberRequest login(MemberRequest memberRequest) throws Exception;
    public boolean checkUserIdValidation(String UserId) throws Exception;

    public boolean checkDuplicateId(String UserId) throws Exception;


    /*
    public List<Member> list() throws Exception;
     */
    public Optional<Member>findByAuth(Long memberNo);












}
