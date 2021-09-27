package com.example.Mini.service.member;

import com.example.Mini.controller.member.request.MemberRequest;
import com.example.Mini.controller.member.session.UserInfo;

import java.util.List;

public interface JPAMemberService2 {
    public List<MemberRequest> list() throws Exception;

    public void remove(Long memberNo) throws Exception;

    public void modify(MemberRequest memberRequest) throws Exception;
    public void modify2(MemberRequest memberRequest) throws Exception;
}