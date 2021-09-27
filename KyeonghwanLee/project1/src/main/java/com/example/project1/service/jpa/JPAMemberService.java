package com.example.project1.service.jpa;

import com.example.project1.controller.jpa.request.MemberRequest;
import com.example.project1.entity.jpa.PrMember;

import java.util.List;
import java.util.Optional;

public interface JPAMemberService {
    public void register(MemberRequest memberRequest) throws Exception;

    public boolean login(MemberRequest memberRequest) throws Exception;
    public boolean checkUserIdValidation(String userId) throws Exception;
    /*
    public List<Member> list() throws Exception;
     */

    public Optional<PrMember> findByAuth(Long memberNo);
}

