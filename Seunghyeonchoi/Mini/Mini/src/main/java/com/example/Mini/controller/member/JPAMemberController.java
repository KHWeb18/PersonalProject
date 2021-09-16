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
                (memberRequest.getAuth().equals("사업자") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));


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
        log.info("**31** 지금 checkNo 상황은? : " + checkNo);

        if (isSuccess) {
            log.info("Login Success");
            // 세션 할당
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