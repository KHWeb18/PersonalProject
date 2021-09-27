package com.example.project1.service.jpa;

import com.example.project1.controller.jpa.request.MemberRequest;
import com.example.project1.entity.jpa.PrMember;
import com.example.project1.entity.jpa.PrMemberAuth;
import com.example.project1.repository.jpa.JPAMemberAuthRepository;
import com.example.project1.repository.jpa.JPAMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JPAMemberServiceImpl implements JPAMemberService {

    @Autowired
    private JPAMemberRepository memberRepository;

    @Autowired
    private JPAMemberAuthRepository memberAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        PrMemberAuth authEntity = new PrMemberAuth(memberRequest.getAuth());
        PrMember memberEntity = new PrMember(memberRequest.getUserId(), memberRequest.getPassword(),
                memberRequest.getName(),memberRequest.getPhoneNo(),memberRequest.getEmail(),
                memberRequest.getAddress());


        log.info("--------------> " + memberRequest.getUserId() + memberRequest.getPassword() + memberRequest.getAddress());

        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);
    }

    @Override
    public boolean login(MemberRequest memberRequest) throws Exception {
        Optional<PrMember> maybeMember = memberRepository.findByUserId(memberRequest.getUserId());

        if (maybeMember == null)
        {
            log.info("login(): 그런 사람 없다.");
            return false;
        }

        PrMember loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword()))
        {
            log.info("login(): 비밀번호 잘못 입력하였습니다.");
            return false;
        }

        return true;
    }

    @Override
    public boolean checkUserIdValidation(String userId) throws Exception {
        Optional<PrMember> maybeMember = memberRepository.findByUserId(userId);

        if (maybeMember == null)
        {
            log.info("login(): 그런 사람 없다.");
            return false;
        }

        return true;
    }

    /*
    @Override
    public List<Member> list() throws Exception {
        return repository.list();
    }
     */

    @Override
    public Optional<PrMember> findByAuth(Long memberNo) {
        return memberRepository.findByAuth(memberNo);
    }
}