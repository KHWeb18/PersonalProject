package com.example.Mini.controller.board;

import com.example.Mini.entity.board.Comment;
import com.example.Mini.service.board.NoticeCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("/noticeboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class NoticeCommentController {

    @Autowired
    private NoticeCommentService service;

    @Autowired
    private HttpSession session;

    @PostMapping("/comment/register")
    public ResponseEntity<Comment> register(@Validated @RequestBody Comment comment) throws Exception {
        log.info("comment register request from vue");
        log.info("**comment : " + comment);

        service.register(comment);

        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping("/comment/{commentNo}")
    public ResponseEntity<Void> remove(@PathVariable("commentNo") String commentNo2) throws Exception {
        int commentNo = Integer.parseInt(commentNo2);
        service.remove(commentNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}