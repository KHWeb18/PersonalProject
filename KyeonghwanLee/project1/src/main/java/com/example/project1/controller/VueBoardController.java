package com.example.project1.controller;


import com.example.project1.entity.Board;
import com.example.project1.service.VueBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/vueboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueBoardController {


    @Autowired
    private VueBoardService service;

    @PostMapping("/register")
    public ResponseEntity<Board> register(@Validated @RequestBody Board board) throws Exception {
        log.info("post register request from vue" + board);

        service.register(board);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Board>> getLists() throws Exception {
        log.info("getLists(): " + service.list());

        //String strNowDate = simpleDateFormat.format(service.list().get(0).getRegDate());

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일"); //원하는 데이터 포맷 지정 String strNowDate = simpleDateFormat.format(nowDate);


        //log.info(""+sdf.parse(service.list().get(0).getRegDate()));

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }


    @GetMapping("/{boardNo}")
    public ResponseEntity<Board> read(@PathVariable("boardNo") Integer boardNo) throws Exception {
        Board board = service.read(boardNo);

        return new ResponseEntity<Board>(board, HttpStatus.OK);
    }

    @PutMapping("/{boardNo}")
    public ResponseEntity<Board> modify(@PathVariable("boardNo") Integer boardNo,
                                        @Validated @RequestBody Board board) throws Exception {
        board.setBoardNo(boardNo);
        service.modify(board);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<Void> remove(@PathVariable("boardNo") Integer boardNo) throws Exception {
        service.remove(boardNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
