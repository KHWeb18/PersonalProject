package com.example.springbackend.controller;

import com.example.springbackend.controller.request.CommentRequest;
import com.example.springbackend.controller.request.ReplyRequest;
import com.example.springbackend.entity.Comment;
import com.example.springbackend.entity.Reply;
import com.example.springbackend.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/reply")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @PostMapping("/register/{commentNo}")
    public ResponseEntity<Void> Register(@PathVariable Long commentNo,
                                         @Validated @RequestBody ReplyRequest replyRequest) throws Exception{
        replyRequest.setCommentNo(commentNo);
        replyService.register(replyRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/lists/{commentNo}")
    public ResponseEntity<List<Reply>> getLists(@PathVariable("commentNo") Long commentNo) throws Exception {

        return new ResponseEntity<List<Reply>>(replyService.getRepliesOfComment(commentNo),HttpStatus.OK);
    }

    @PutMapping("/{replyNo}")
    public ResponseEntity<Void> modify(@PathVariable("replyNo") Long replyNo,
                                       @RequestBody ReplyRequest replyRequest) throws Exception {

        List<Reply> replyList = replyService.findByReplyNo(replyNo);
        Reply replyRead = replyList.get(0);
        replyService.modify(replyRead, replyRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
