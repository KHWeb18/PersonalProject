package com.example.Mini.controller.board;

import com.example.Mini.controller.member.request.FreeRequest;
import com.example.Mini.entity.board.Free;
import com.example.Mini.service.board.FreeBoardService;
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
@RequestMapping("/freeboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FreeBoardController {

    @Autowired
    private FreeBoardService service;

    @Autowired
    private HttpSession session;

    @PostMapping("/register")
    public ResponseEntity<Free> register(@Validated @RequestBody Free board) throws Exception {
        log.info("post register request from vue");
        log.info("**board : " + board);

        service.register(board);

        String Content = board.getContent();

        FreeRequest request = new FreeRequest();

        service.findMemberNo(Content);

        int no = (int) session.getAttribute("registerNo");

        System.out.println("=======BoardController========");
        System.out.println("세션에 저장 되 있는 변수 : "+no);
        System.out.println("==============================");
        board.setBoardNo(no);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Free>> getLists () throws Exception {
        log.info("getFreeLists() ");

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{boardNo}")
    public ResponseEntity<Free> read(@PathVariable("boardNo") Integer boardNo) throws Exception {

        Free board = service.read(boardNo);

        return new ResponseEntity<Free>(board, HttpStatus.OK);
    }

    @PutMapping ("/{boardNo}")
    public ResponseEntity<Free> modify(@PathVariable("boardNo") Integer boardNo,
                                        @Validated @RequestBody Free board) throws Exception {
        board.setBoardNo(boardNo);
        service.modify(board);

        return new ResponseEntity<Free>(board, HttpStatus.OK);
    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<Void> remove(@PathVariable("boardNo") Integer boardNo) throws Exception {
        service.remove(boardNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}