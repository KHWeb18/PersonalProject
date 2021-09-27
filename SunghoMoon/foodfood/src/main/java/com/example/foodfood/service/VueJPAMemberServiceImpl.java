package com.example.foodfood.service;

import com.example.foodfood.entity.VueMember;
import com.example.foodfood.repository.VueJPAMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueJPAMemberServiceImpl implements VueJPAMemberService {

    @Autowired
    private VueJPAMemberRepository repository;

    @Override
    public void register(VueMember member) throws Exception {
        repository.save(member);
    }
}