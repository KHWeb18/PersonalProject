package com.example.Mini.service.member;

import com.example.Mini.controller.member.request.MemberRequest;
import com.example.Mini.entity.member.Member;
import com.example.Mini.entity.member.MemberAuth;
import com.example.Mini.repository.member.JPAMemberAuthRepository;
import com.example.Mini.repository.member.JPAMemberRepository;
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

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(memberRequest.getUserId(), memberRequest.getPassword(), memberRequest.getNickname());
        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);
    }

    @Override
    public String findMeberNo(MemberRequest memberRequest) throws Exception {
        return  memberRepository.findMeberNo(memberRequest.getUserId());
    }

    @Override
    public String findNickname(MemberRequest memberRequest) throws Exception {
        return memberRepository.findNickname(memberRequest.getUserId());
    }

    @Override
    public String findAuth(Long memberNo) throws Exception {
        return memberRepository.findAuth(memberNo);
    }

    @Override
    public boolean login(MemberRequest memberRequest) throws Exception {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getUserId());
        log.info("**33** ?????? memberRequest ?????????? : " + memberRequest);

        log.info("***********maybeMember ?????? " + maybeMember);
        log.info(String.valueOf(maybeMember));

        String check = String.valueOf(maybeMember);
        log.info("***********check ?????? " + check);



        if (check.equals("Optional.empty"))
        {
            log.info("login(): ?????? ?????? ??????.");
            return false;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword()))
        {
            log.info("login(): ???????????? ?????? ?????????????????????.");
            return false;
        }

        return true;
    }

    @Override
    public boolean checkUserIdValidation(String userId) throws Exception {
        Optional<Member> maybeMember = memberRepository.findByUserId(userId);

        log.info("***********maybeMember ?????? " + maybeMember);
        log.info(String.valueOf(maybeMember));

        String check = String.valueOf(maybeMember);
        log.info("***********check ?????? " + check);


        if (check.equals("Optional.empty"))
        {
            log.info("checkUserIdValidation() : ?????? ?????????");
            return false;
        }

        return true;
    }



    @Override
    public List<MemberRequest> list() throws Exception {
        return memberRepository.list();
    }

    @Override
    public String findByAuth(Long memberNo) {
        return memberRepository.findByAuth(memberNo);
    }

    @Override
    public String deleteUser(String userId) {
        return memberRepository.deleteUser(userId);
    }



}