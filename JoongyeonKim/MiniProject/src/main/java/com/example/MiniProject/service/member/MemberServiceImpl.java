package com.example.MiniProject.service.member;

import com.example.MiniProject.controller.member.MemberRequest;
import com.example.MiniProject.entity.funding.Funding;
import com.example.MiniProject.entity.member.Member;
import com.example.MiniProject.entity.member.MemberAuth;
import com.example.MiniProject.repository.member.MemberAuthRepository;
import com.example.MiniProject.repository.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberAuthRepository memberAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean register(MemberRequest memberRequest) throws Exception {
        // Repository 쿼리부분을 연결해주는 코드 작성
        List<Member> emailConfirm = memberRepository.findByEmailCheck(memberRequest.getEmail());

        if (!emailConfirm.isEmpty()) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }

        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        String encodedPasswordConfirm = passwordEncoder.encode(memberRequest.getPasswordConfirm());
        memberRequest.setPasswordConfirm(encodedPasswordConfirm);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(memberRequest.getEmail(), memberRequest.getUserName(),
                memberRequest.getPassword(), memberRequest.getPasswordConfirm());

        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);

        return true;
    }
    /*
    private void validateDuplicateMember(String email) {
        List<Member> findMembers = memberRepository.findByEmailCheck(email);
        if (!findMembers.isEmpty()) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }
    }*/

    @Override
    public boolean login(MemberRequest memberRequest) throws Exception {
        Optional<Member> maybeMember = memberRepository.findByEmail(memberRequest.getEmail());

        if (maybeMember == null)
        {
            log.info("login(): 그런 사람 없다.");
            return false;
        }

        Member loginMember = maybeMember.get();

        //matches: 두 패스워드가 일치하는지 확인
        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword()))
        {
            log.info("login(): 비밀번호 잘못 입력하였습니다");
            return false;
        }

        return true;
    }

    @Override
    public Optional<Member> findByAuth(Long auth) {
        return memberRepository.findByAuth(auth);
    }

    @Override
    public List<Member> lists() throws Exception {
        return memberRepository.findAll();
    }
}