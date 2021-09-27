package com.example.foodfood.service.jpa;

import com.example.foodfood.entity.jpa.TestMember;

import java.util.List;

public interface JPATestMemberService {

    public List<TestMember> findByJPQL() throws Exception;
    public List<Object[]> findSpecificByJPQL() throws Exception;
}