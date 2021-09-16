package com.example.MiniProject.service.member;

import com.example.MiniProject.controller.member.MemberRequest;
import com.example.MiniProject.entity.funding.Funding;
import com.example.MiniProject.entity.member.Member;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface MemberService {
    public boolean register(MemberRequest memberRequest) throws Exception;

    public boolean login(MemberRequest memberRequest) throws Exception;

    public List<Member> lists() throws Exception;

    public Optional<Member> findByAuth(Long auth);

    //public boolean emailCheck(MemberRequest memberRequest) throws Exception;

}
