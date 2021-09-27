package com.example.Mini.controller.board;

import com.example.Mini.entity.board.Comment;
import com.example.Mini.entity.board.Notice;
import com.example.Mini.service.board.NoticeCommentService2;
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
@RequestMapping("/noticeboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class NoticeCommentListController {
    //FoodList용 컨트롤러

    @Autowired
    private NoticeCommentService2 service;

    @Autowired
    private HttpSession session;

    @GetMapping("/comment/{boardNo}")
    public ResponseEntity<List<Comment>> getLists (@PathVariable("boardNo") Integer boardNo) throws Exception {

        log.info("getLists(): " + service.list(boardNo));

        return new ResponseEntity<>(service.list(boardNo), HttpStatus.OK);
    }

}