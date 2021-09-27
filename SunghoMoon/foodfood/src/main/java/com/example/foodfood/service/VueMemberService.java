package com.example.foodfood.service;

import com.example.foodfood.entity.Member;

import java.util.List;

public interface VueMemberService {
    public void register(Member member) throws Exception;
    public void login(Member member) throws Exception;
    public List<Member> list() throws Exception;
}