package com.example.springbackend.controller;

import com.example.springbackend.controller.request.BoardRequest;
import com.example.springbackend.entity.Board;
import com.example.springbackend.repository.BoardRepository;
import com.example.springbackend.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BoardController {

    @Autowired
    private BoardService service;

    @Autowired
    private BoardRepository boardRepository;

    @PostMapping("/register")
    public ResponseEntity<Void> Register(@Validated @RequestBody BoardRequest boardRequest)
        throws Exception{
        log.info("Register Board(): " + boardRequest.getWriter() + ", " + boardRequest.getTitle()+ ", " +
                boardRequest.getContent());

        service.register(boardRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity <List<Board>> getLists ( ) throws Exception {
        log.info("getLists(): " + service.boardFindAll());

        return new ResponseEntity<>(service.boardFindAll(), HttpStatus.OK);
    }

    @GetMapping("/{boardNo}")
    public ResponseEntity<Board> read(@PathVariable("boardNo") Long boardNo) throws Exception {
        List<Board> board = service.findByBoardNo(boardNo);
        Board boardRead = board.get(0);
        return new ResponseEntity<Board>(boardRead, HttpStatus.OK);
    }

    @PutMapping("/{boardNo}")
    public ResponseEntity<Void> modify(@PathVariable("boardNo") Long boardNo,
                                       @RequestBody BoardRequest boardRequest) throws Exception {

        List<Board> board = service.findByBoardNo(boardNo);
        Board boardRead = board.get(0);
        service.modify(boardRead, boardRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<Void> delete(@PathVariable("boardNo") Long boardNo) throws Exception {
        service.delete(boardNo);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
