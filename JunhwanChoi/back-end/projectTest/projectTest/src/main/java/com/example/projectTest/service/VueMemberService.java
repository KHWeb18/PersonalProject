package com.example.projectTest.service;


import com.example.projectTest.entity.Member;

import java.util.List;

public interface VueMemberService {
    public void register(Member member) throws Exception;

    public List<Member> list() throws Exception;

    public Member read(Integer memberNo) throws Exception;

    public void remove(Integer memberNo) throws Exception;

    public void modify(Member member) throws Exception;

}
