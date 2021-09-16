package com.example.Mini.service.member;

import com.example.Mini.controller.member.request.FoodRequest;
import com.example.Mini.controller.member.request.MemberRequest;
import com.example.Mini.entity.member.Member;

import java.util.List;

public interface JPAMemberService {
    public void register(MemberRequest memberRequest) throws Exception;

    public boolean login(MemberRequest memberRequest) throws Exception;

    public List<MemberRequest> list() throws Exception;

    public String findMeberNo(MemberRequest memberRequest) throws Exception;

    public String findAuth(Long memberNo) throws Exception;

    public String findNickname(MemberRequest memberRequest) throws Exception;

    public boolean checkUserIdValidation(String userId) throws Exception;

    public String findByAuth(Long memberNo);


    public String deleteUser(String userId) throws Exception;








}