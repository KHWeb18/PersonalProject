package com.example.springbackend.controller;

import com.example.springbackend.controller.request.MemberRequest;
import com.example.springbackend.controller.session.UserInfo;
import com.example.springbackend.entity.Board;
import com.example.springbackend.entity.Member;
import com.example.springbackend.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    private UserInfo info;

    @Autowired
    private MemberService service;

    private HttpSession session;

    @PostMapping("/register")
    public ResponseEntity<Void> Register(@Validated @RequestBody MemberRequest memberRequest)
            throws Exception {
        log.info("Register(): " + memberRequest.getMember_id() + ", " + memberRequest.getMember_pw()
                + ", " + memberRequest.getEmail() + ", " + memberRequest.getName());

        service.register(memberRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserInfo> Login(@RequestBody MemberRequest memberRequest, HttpServletRequest request)
            throws Exception {
        log.info("Login() - member_id: " + memberRequest.getMember_id() + ", member_pw: " + memberRequest.getMember_pw());

        Boolean isSuccess = service.login(memberRequest);

        if(isSuccess) {
            log.info("Login Success");
            // 세션 할당
            info = new UserInfo();
            info.setMember_id(memberRequest.getMember_id());
            log.info("Session Info: " + info);

            session = request.getSession();
            session.setAttribute("member", info);
        }else {
            log.info("Login Failure");
            info = null;
        }
        return new ResponseEntity<UserInfo>(info, HttpStatus.OK);
    }
    @GetMapping("/check/{member_id}")
    public ResponseEntity<Boolean> checkDuplicate(@PathVariable("member_id") String member_id) throws Exception {
        Boolean maybeMember = service.checkUserIdValidation(member_id);

        return new ResponseEntity<Boolean>(maybeMember, HttpStatus.OK);
    }


    @PostMapping("/removeSession")
    public ResponseEntity<Boolean> removeSession(HttpServletRequest request) throws Exception {
        Boolean mustFalse = false;

        session.invalidate();

        return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
    }
    @GetMapping("/read/{member_id}")
    public ResponseEntity<Member> read(@PathVariable("member_id") String member_id) throws Exception {
        Member member = service.findByMemberId(member_id);
        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }

    @DeleteMapping("/{memberNo}")
    public ResponseEntity<Void> delete(@PathVariable("memberNo") Long memberNo) throws Exception {
        service.delete(memberNo);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PutMapping("/modify/{memberNo}")
    public ResponseEntity<Void> modify(@PathVariable("memberNo") Long memberNo,
                                       @RequestBody MemberRequest memberRequest) throws Exception {
        List<Member> member = service.findByMemberNo(memberNo);
        Member memberRead = member.get(0);
        service.modify(memberRead, memberRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
