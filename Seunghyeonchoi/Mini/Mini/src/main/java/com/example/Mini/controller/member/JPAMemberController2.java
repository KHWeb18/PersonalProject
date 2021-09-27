package com.example.Mini.controller.member;

import com.example.Mini.controller.member.request.MemberRequest;
import com.example.Mini.controller.member.session.UserInfo;
import com.example.Mini.entity.board.Notice;
import com.example.Mini.service.food.JPAFoodService2;
import com.example.Mini.service.member.JPAMemberService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/jpamember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JPAMemberController2 {

    @Autowired
    private JPAMemberService2 service;

    @GetMapping("/mlists")
    public ResponseEntity<List<MemberRequest>> getLists () throws Exception {
        log.info("getLists(): " + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @DeleteMapping("/{memberNo}")
    public ResponseEntity<Void> remove(@PathVariable("memberNo") Long memberNo) throws Exception {
        log.info("여기까지는 ok ok ok ok ok :::: " + memberNo);

        service.remove(memberNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping ("/{userId}")
    public ResponseEntity<MemberRequest> modify(@PathVariable("userId") String userId,
                                                @RequestBody MemberRequest memberRequest) throws Exception {

        log.info("incoming data : " + memberRequest);

        log.info("memberRequest.getPassword()는? : " + memberRequest.getPassword());

        if (Objects.equals(memberRequest.getPassword(), "")) {
            log.info(memberRequest.getUserId() + " || " + "profileUpdate(no password)");
            service.modify2(memberRequest);  // 비밀번호 없이 들어오는 경우
        } else {
            memberRequest.setUserId(userId);  // 비밀번호 포함해서 오는 경우
            memberRequest.setPassword(memberRequest.getPassword());
            log.info(memberRequest.getUserId() + " || " + "profileUpdate(with password)");
            service.modify(memberRequest);
        }

        return new ResponseEntity<MemberRequest>(memberRequest, HttpStatus.OK);
    }
}