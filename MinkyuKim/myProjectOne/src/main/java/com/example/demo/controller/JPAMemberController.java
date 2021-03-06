package com.example.demo.controller;


import com.example.demo.controller.request.MemberRequest;
import com.example.demo.controller.session.UserInfo;
import com.example.demo.entity.Member;
import com.example.demo.entity.Product;
import com.example.demo.service.JPAMemberService;
import com.example.demo.service.JpaMemberModifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JPAMemberController {

    private UserInfo info;

    @Autowired
    private JPAMemberService service;
    //private JpaMemberModifyService service;

    private HttpSession session;


    @PostMapping("/register")
    public ResponseEntity<Void> jpaRegister(
            @Validated @RequestBody MemberRequest memberRequest) throws Exception {

        log.info("jpaRegister(): " + memberRequest.getUserId() + ", " + memberRequest.getPassword() + ", " +
                (memberRequest.getAuth().equals("ํ๋งคํ์") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        log.info("name() -" + memberRequest.getName());

        service.register(memberRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
/*
    @GetMapping("/{userId}")
    public ResponseEntity<MemberRequest> read(@PathVariable("userId") String userId) throws Exception {
        MemberRequest memberRequest = service.read(userId);

        return new ResponseEntity<MemberRequest>(memberRequest, HttpStatus.OK);
    }
*/
    /*
    @PutMapping("/{userId}")
    public ResponseEntity<MemberRequest> modifyMember(@PathVariable("userId") String userId,
                                                 @Validated @RequestBody MemberRequest memberRequest) throws Exception {

        log.info("modifyMember() : " + memberRequest.getUserId());

        memberRequest.setUserId(userId);


        log.info("modifyMember(): " + memberRequest);

        service.modify(memberRequest);

        return new ResponseEntity<>(memberRequest, HttpStatus.OK);
    }*/

    @PostMapping("/login")
    public ResponseEntity<UserInfo> jpaLogin(
            @RequestBody MemberRequest memberRequest,
            HttpServletRequest request
    ) throws Exception {

        // id pw๊ฐ null๊ฐ์ธ๊ฒ์ RequestBody๊ฐ ๋ฐ์ง ๋ชปํ๋ค๋ ์๋ฏธ
        log.info("jpaLogin() - userId: " + memberRequest.getUserId() + ", password: " + memberRequest.getPassword());

        // 1) jpa์์ ๋์ด๊ฐ๊ณ?
        Boolean isSuccess = service.login(memberRequest);

        // 2) ๋ก๊ทธ์ธ ์ฑ๊ณต์ ํ?์ ์ธ์์ฒ๋ฆฌํ๊ฒ?๋ค
        if (isSuccess) {
            log.info("Login Success");
            // 3) ์ธ์ ํ?๋น
            info = new UserInfo();
            info.setUserId(memberRequest.getUserId());
            log.info("Session Info: " + info);

            session = request.getSession();
            session.setAttribute("member", info);

        } else {
            log.info("Login Failure");
            info = null;
        }

        // return new ResponseEntity<Boolean>(isSuccess, HttpStatus.OK);
        return new ResponseEntity<UserInfo>(info, HttpStatus.OK);
    }

    @PostMapping("/needSession")
    public ResponseEntity<Boolean> postNeedSession(HttpServletRequest request) throws Exception {

        //UserInfo info = (UserInfo) session.getAttribute("member");
        Object obj = session.getAttribute("member");

        Boolean isLogin = false;

        if (obj != null) {
            log.info("Session Info: " + info);

            isLogin = service.checkUserIdValidation(info.getUserId());

            return new ResponseEntity<Boolean>(isLogin, HttpStatus.OK);
        }
        return new ResponseEntity<Boolean>(isLogin, HttpStatus.OK);
    }

    // ๋ก๊ทธ์ธ -> ๊ฒ์๋ฌผ ์์ฑ
    //       -> ๊ฒ์๋ฌผ ์์?
    //       -> ํ๋ก์ฐ
    //       -> ๋๊ธ ๋ฌ๊ธฐ
    //       -> ์ญ์?

    // ๋ก๊ทธ์์ -> ๊ฒ์๋ฌผ ์์ฑ
    // Spring ์์ฒด์์ ์ฒ๋ฆฌ๊ฐ ๋ถ๊ฐ๋ฅํ๋ฏ๋ก
    // ๋ก๊ทธ์์์ Vue์ชฝ์ ์ธ์์ด ์๋ค๋ ์?๋ณด๋ฅผ ์?๋ฌํด์ค์ผํ๋ค.
    // ๊ทธ๋ฆฌ๊ณ? ์ฌ์ฉ์๊ฐ ๊ฒ์๋ฌผ ์์ฑ์ ๋๋ฅด๋ฉด ์ด ์?๋ณด(์ฐธ, ๊ฑฐ์ง)์ ๋ณด๊ณ?
    // ๊ฐ์?๋ก ๋ก๊ทธ์ธ ํ์ด์ง๋ก ๋ณด๋ด๊ฑฐ๋ ์ฐธ(์ธ์์ด ์์)์ด๋ฉด ๊ทธ๋๋ก ์ฒ๋ฆฌํ๋ ๋ฐฉ์์ ์ทจํ๋๋ก ๋ง๋ค๋ฉด ๋จ

    @PostMapping("/removeSession")
    public ResponseEntity<Boolean> removeSession(HttpServletRequest request) throws Exception {
        Boolean mustFalse = false;

        session.invalidate();
        //์ธ์์ด ์๋๊ฒ์ผ๋ก false๋ฅผ ๋ฆฌํดํ๋ค
        return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<Void> jpaJPQLTest(
            @RequestBody MemberRequest memberRequest) throws Exception {

        log.info("jpaJPQLTest()");

        Optional<Member> maybeMember = service.findByAuth(new Long(3));
        // get์ ์?๋ณด๊ฐ์?ธ์ค๊ธฐ. ๊ฐ์?ธ์ฌ ๋ฐ์ดํฐ๊ฐ ์์ผ๋ฉด ๊ทธ๋ฅ ๋?
        Member member = maybeMember.get();

        // ์ฌ์์๋ก ๋์ด์ค๋ฉด ROLE_BUSINESS๋ก ์๋๋ฉด ROLE_CUSTOMER๋ก ๋ณด์ด๊ฒ
        log.info("Auth: " + (member.getAuthList().get(0).getAuth().equals("ํ๋งคํ์") ?
                "ROLE_BUSINESS" : "ROLE_CUSTOMER"));

        return new ResponseEntity<Void>(HttpStatus.OK);
    }



}