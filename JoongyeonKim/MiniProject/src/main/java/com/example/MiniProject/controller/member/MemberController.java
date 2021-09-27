package com.example.MiniProject.controller.member;

import com.example.MiniProject.controller.member.session.UserInfo;
import com.example.MiniProject.entity.funding.Funding;
import com.example.MiniProject.entity.member.Member;
import com.example.MiniProject.service.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    private UserInfo info;

    @Autowired
    private MemberService service;

    private HttpSession session;

    @PostMapping("/register")
    public ResponseEntity<Boolean> jpaRegister(
            @Validated @RequestBody MemberRequest memberRequest) throws Exception {
        log.info("jpaRegister(): " + memberRequest.getEmail() + ", " + memberRequest.getUserName()
                + ", " + memberRequest.getPassword() + ", " + memberRequest.getPasswordConfirm());

        /*
        boolean ableEmail = service.emailCheck(memberRequest);

        if (memberRequest.getPassword().equals(memberRequest.getPasswordConfirm())) {
            if (ableEmail) {
                log.info("able email");
                log.info("회원가입 성공");
                service.register(memberRequest);
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else {
                log.info("unable email");
                this.info = null;
            }
        } else  {
            log.info("회원가입 실패");
            this.info = null;
        }
         */

        service.register(memberRequest);

        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserInfo> jpaLogin(
            @RequestBody MemberRequest memberRequest,
            HttpServletRequest request
    ) throws Exception {

        log.info("jpaLogin() - email: " + memberRequest.getEmail() + ", password: " + memberRequest.getPassword());

        Boolean isSuccess = service.login(memberRequest);

        if (isSuccess) {
            log.info("Login Success");
            // 세션 할당
            info = new UserInfo();
            info.setEmail(memberRequest.getEmail());
            log.info("Session Info: " + info);

            session = request.getSession();
            session.setAttribute("member", info);
        } else {
            log.info("Login Failure");
            info = null;
        }

        return new ResponseEntity<UserInfo>(info, HttpStatus.OK);
    }

    // 로그인 -> 게시물 작성
    //       -> 게시물 수정
    //       -> 팔로우
    //       -> 댓글 달기
    //       -> 삭제

    // 로그아웃 -> 게시물 작성
    // Spring 자체에서 처리가 불가능하므로
    // 로그아웃시 Vue쪽에 세션이 없다는 정보를 전달해줘야한다.
    // 그리고 사용자가 게시물 작성을 누르면 이 정보(참, 거짓)을 보고
    // 강제로 로그인 페이지로 보내거나 참(세션이 있음)이면 그대로 처리하는 방식을 취하도록 만들면 됨
    @RequestMapping("/logout")
    public ResponseEntity<Boolean> logout(HttpServletRequest request) throws Exception {
        Boolean mustFalse = false;

        session.invalidate();

        return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
    }
    @GetMapping("/lists")
    public ResponseEntity<List<Member>> getLists() throws Exception {
        log.info("getLists(): " + service.lists());

        return new ResponseEntity<>(service.lists(), HttpStatus.OK);
    }
}