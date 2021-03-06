package com.example.foodfood.controller.vue.jpa;

import com.example.foodfood.controller.vue.jpa.request.MemberRequest;
import com.example.foodfood.controller.vue.session.UserInfo;
import com.example.foodfood.entity.jpa.Member;
import com.example.foodfood.service.jpa.JPAMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/jpamember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JPAMemberController {

    private UserInfo info;

    @Autowired
    private JPAMemberService service;

    private HttpSession session;

    @PostMapping("/register")
    public ResponseEntity<Void> jpaRegister(
            @Validated @RequestBody MemberRequest memberRequest) throws Exception {
        log.info("jpaRegister(): " + memberRequest.getUserId() + ", " + memberRequest.getPassword() + ", " +
                (memberRequest.getAuth().equals("ėŽėė") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        service.register(memberRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserInfo> jpaLogin(
            @RequestBody MemberRequest memberRequest,
            HttpServletRequest request
    ) throws Exception {

        log.info("jpaLogin() - userId: " + memberRequest.getUserId() + ", password: " + memberRequest.getPassword());

        Boolean isSuccess = service.login(memberRequest);

        if (isSuccess) {
            log.info("Login Success");
            // ėļė í ëđ
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

    // ëĄę·ļėļ -> ęēėëŽž ėėą
    //       -> ęēėëŽž ėė 
    //       -> íëĄė°
    //       -> ëęļ ëŽęļ°
    //       -> ė­ė 

    // ëĄę·ļėė -> ęēėëŽž ėėą
    // Spring ėėēīėė ėēëĶŽę° ëķę°ëĨíëŊëĄ
    // ëĄę·ļėėė VueėŠ―ė ėļėėī ėëĪë ė ëģīëĨž ė ëŽíīėĪėžíëĪ.
    // ę·ļëĶŽęģ  ėŽėĐėę° ęēėëŽž ėėąė ëëĨīëĐī ėī ė ëģī(ė°ļ, ęą°ė§)ė ëģīęģ 
    // ę°ė ëĄ ëĄę·ļėļ íėīė§ëĄ ëģīëīęą°ë ė°ļ(ėļėėī ėė)ėīëĐī ę·ļëëĄ ėēëĶŽíë ë°Đėė ė·ĻíëëĄ ë§ëĪëĐī ëĻ
    @PostMapping("/removeSession")
    public ResponseEntity<Boolean> removeSession(HttpServletRequest request) throws Exception {
        Boolean mustFalse = false;

        session.invalidate();

        return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<Void> jpaJPQLTest(
            @RequestBody MemberRequest memberRequest) throws Exception {

        log.info("jpaJPQLTest()");

        Optional<Member> maybeMember = service.findByAuth(new Long(3));
        Member member = maybeMember.get();

        log.info("Auth: " + (member.getAuthList().get(0).getAuth().equals("ėŽėė") ?
                "ROLE_BUSINESS" : "ROLE_CUSTOMER"));

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}