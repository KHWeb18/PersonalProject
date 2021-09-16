package com.example.Mini.service.member;


import com.example.Mini.controller.member.request.MemberRequest;
import com.example.Mini.repository.member.JPAMemberRepository2;
import com.example.Mini.service.member.JPAMemberService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

// Service는 여기서 register가 여러 방식으로 동작할 수 있음을 명시한다.
// 또한 Controller의 Autowired에 자동으로 연결되도록 서포트한다.
@Service
public class JPAMemberServiceImpl2 implements JPAMemberService2 {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JPAMemberRepository2 repository;


    @Override
    public List<MemberRequest> list() throws Exception {
        return repository.list();
    }

    @Override
    public void remove(Long memberNo) throws Exception {
        repository.delete(memberNo);
    }

    @Override
    public void modify(MemberRequest memberRequest) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        repository.update(memberRequest);
    }

    @Override
    public void modify2(MemberRequest memberRequest) throws Exception {

        repository.update2(memberRequest);
    }

}