package com.example.Mini.controller.board;

import com.example.Mini.entity.board.Comment;
import com.example.Mini.service.board.FreeCommentService2;
import com.example.Mini.service.board.NoticeCommentService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/freeboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FreeCommentListController {

    @Autowired
    private FreeCommentService2 service;

    @Autowired
    private HttpSession session;

    @GetMapping("/comment/{boardNo}")
    public ResponseEntity<List<Comment>> getLists (@PathVariable("boardNo") Integer boardNo) throws Exception {

        log.info("getLists(): " + service.list(boardNo));

        return new ResponseEntity<>(service.list(boardNo), HttpStatus.OK);
    }

}