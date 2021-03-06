package com.example.Mini.controller.member;

import com.example.Mini.controller.member.request.MemberRequest;
import com.example.Mini.controller.member.session.UserInfo;
import com.example.Mini.service.member.JPAMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        log.info("jpaRegister(): " + memberRequest.getUserId() + ", " + memberRequest.getNickname() + ", " + memberRequest.getPassword() + ", " +
                (memberRequest.getAuth().equals("ėŽėė") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));


        log.info("** log.info(memberRequest.getUserId()) : " + memberRequest.getUserId());

        Boolean isSuccess = service.checkUserIdValidation(memberRequest.getUserId());
        if (isSuccess) {
            log.info("Register Failure");
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

        } else {
            log.info("Register Success");
            service.register(memberRequest);

            return new ResponseEntity<Void>(HttpStatus.OK);
        }

//        return new ResponseEntity<Void>(HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity<UserInfo> jpaLogin(
            @RequestBody MemberRequest memberRequest,
            HttpServletRequest request
    ) throws Exception {

        log.info("jpaLogin() - userId: " + memberRequest.getUserId() + ", password: " + memberRequest.getPassword());

        Boolean isSuccess = service.login(memberRequest);

        Long checkNo = Long.parseLong(service.findMeberNo(memberRequest));

        String No = service.findAuth(checkNo);
        String Nickname = service.findNickname(memberRequest);
        log.info("**31** ė§ęļ checkNo ėíĐė? : " + checkNo);

        if (isSuccess) {
            log.info("Login Success");
            // ėļė í ëđ
            info = new UserInfo();
            info.setUserId(memberRequest.getUserId());
            info.setAuth(No);
            info.setNickname(Nickname);
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

//    @GetMapping("/mlists")
//    public ResponseEntity<List<MemberRequest>> getLists () throws Exception {
//        log.info("getLists(): " + service.list());
//
//
//        return new ResponseEntity<>(service.list(), HttpStatus.OK);
//    }

//    public ResponseEntity<MemberRequest> jpaList(@RequestBody MemberRequest memberRequest, HttpServletRequest request)
//            throws Exception {
//
//        List memberList = service.list();
//
//        MemberRequest rInfo = new MemberRequest();
////        info = new UserInfo();
//        rInfo.setMemberNo(memberRequest.getMemberNo());
//        rInfo.setUserId(memberRequest.getUserId());
//        rInfo.setNickname(memberRequest.getNickname());
//        rInfo.setRegDage(memberRequest.getRegDate());
//
//        return new ResponseEntity<UserInfo>(rInfo, HttpStatus.OK);
//    }

//    @GetMapping("/lists")
//    public ResponseEntity<List<MemberRequest>> getLists () throws Exception {
//        log.info("getLists(): " + service.list());
//
//        return new ResponseEntity<>(service.list(), HttpStatus.OK);
//    }





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

    @PostMapping("/removeMember")
    public ResponseEntity<UserInfo> removeMember(@RequestBody MemberRequest memberRequest,
                                                          HttpServletRequest request) throws Exception {

       service.deleteUser(memberRequest.getUserId());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}