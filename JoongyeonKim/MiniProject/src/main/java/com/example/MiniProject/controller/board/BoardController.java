package com.example.MiniProject.controller.board;

import com.example.MiniProject.controller.funding.FundingRequest;
import com.example.MiniProject.controller.member.MemberRequest;
import com.example.MiniProject.entity.board.Board;
import com.example.MiniProject.service.board.BoardService;
import com.example.MiniProject.service.funding.FundingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BoardController {

    @Autowired
    private BoardService service;

    @PostMapping("/register")
    public ResponseEntity<Void> boardRegister(
            @Validated @RequestBody BoardRequest boardRequest) throws Exception {
        log.info("boardRegister(): " + boardRequest.getEmail() + ", " + boardRequest.getTitle()
                + ", " + boardRequest.getContent());

        service.register(boardRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @GetMapping("/lists")
    public ResponseEntity<List<Board>> getLists() throws Exception {
        // log.info("getLists():" + service.lists());
        log.info("getLists()");

        return new ResponseEntity<>(service.lists(), HttpStatus.OK);
    }
}
