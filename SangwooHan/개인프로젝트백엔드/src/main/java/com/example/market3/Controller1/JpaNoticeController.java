package com.example.market3.Controller1;

import com.example.market3.Controller1.MemberRequset.BoardRequest;
import com.example.market3.Controller1.MemberRequset.NoticeCommentRequest;
import com.example.market3.Entity.JpaBoard;
import com.example.market3.Entity.JpaBoardComment;
import com.example.market3.Entity.JpaNotice;
import com.example.market3.Entity.JpaNoticeComment;
import com.example.market3.Service.JpaNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jpaNotice")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class JpaNoticeController {
        @Autowired
        JpaNoticeService service;

    @PostMapping("/register")
    public ResponseEntity<JpaNotice> registermembers(@Validated @RequestBody JpaNotice jpaNotice) throws Exception {
        log.info("post register request from vue");

        service.register(jpaNotice);

        return new ResponseEntity<>(jpaNotice, HttpStatus.OK);
    }
    @GetMapping("/noticelist")
    public ResponseEntity<List<JpaNotice>> getListsBoards () throws Exception {
        log.info("getLists(): " + service.Noticelist());

        return new ResponseEntity<>(service.Noticelist(), HttpStatus.OK);
    }
    @GetMapping("/{boardNo}")
    public ResponseEntity<JpaNotice> read(@PathVariable("boardNo") Long boardNo) throws Exception {
        Optional<JpaNotice> jpaNotice = service.read(boardNo);
        JpaNotice jpaNotice1 = jpaNotice.get();
        log.info("jpa" + jpaNotice1);
        return new ResponseEntity<JpaNotice>(jpaNotice1, HttpStatus.OK);
    }

    @PostMapping("/noticeComments/{boardNo}")
    public ResponseEntity<Void> Noticecommanents(@PathVariable("boardNo") Long boardNo, @Validated @RequestBody NoticeCommentRequest noticeCommentRequest) throws Exception {

        noticeCommentRequest.setBoardNo(boardNo);


        service.Noticecommanents(noticeCommentRequest);

        return new ResponseEntity<Void>( HttpStatus.OK);

    }
    @GetMapping("/NoticeCommentList/{boardNo}")
    public ResponseEntity<List<JpaNoticeComment>> getNoticeCommentList (@PathVariable("boardNo") Long boardNo) throws Exception {


        //  service.finByComments2(boardNo);
        service.finByNoticeComments(boardNo);


        return new ResponseEntity<>(service.finByNoticeComments(boardNo),HttpStatus.OK);

    }
    @PostMapping("/vuecount/{boardNo}")
    public ResponseEntity<Void> Noticevuecount (@PathVariable("boardNo") Long boardNo) throws  Exception {

        service.NoticeaddVueCount(boardNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/ModifyComments/{boardNo}")
    public ResponseEntity<Void> ModifyComment(@PathVariable("boardNo")Long boardNo, @Validated @RequestBody NoticeCommentRequest noticeCommentRequest) throws  Exception {

        noticeCommentRequest.setBoardNo(boardNo);


        service.ModifyComment(noticeCommentRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteComment/{noticeCommentNo}")
    public ResponseEntity<Void> deleteComment (@PathVariable("noticeCommentNo") Long noticeCommentNo) throws  Exception{

        service.deleteComment(noticeCommentNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteNotice/{boardNo}")
    public  ResponseEntity<Void> deleteNotice (@PathVariable("boardNo")Long boardNo) throws  Exception {

        service.deleteNotice(boardNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
