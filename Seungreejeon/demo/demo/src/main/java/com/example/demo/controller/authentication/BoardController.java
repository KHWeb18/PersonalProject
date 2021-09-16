package com.example.demo.controller.authentication;


import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import com.example.demo.service.BoardService;
import com.example.demo.service.BoardServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository repository;

    @PostMapping("/post")
    public ResponseEntity<Void> postBoard(@RequestBody Board board) throws Exception {
        log.info("Board Posting : " + board.toString());

        boardService.postBoard(board);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<Board>> fetchBoard() throws Exception {

        List<Board> getFetch = boardService.fetchBoard();

        log.info("fetch Board ()" + boardService.fetchBoard());

        return new ResponseEntity<List<Board>>(getFetch, HttpStatus.OK);
    }

    @PutMapping("/modify/{boardNo}")
    public ResponseEntity<Board> modify(@Validated @RequestBody Board board,
                                        @PathVariable("boardNo") Long boardNo) throws Exception {

        log.info("modify() : " + boardNo + "boardcontent : " + board.toString());
//찾아서
        Optional<Board> modify = repository.findById(boardNo);
//수정하는
        modify.ifPresent(selectBoard -> {
            selectBoard.setContent(board.getContent());
            selectBoard.setTitle(board.getTitle());

            repository.save(selectBoard);
        });
        return new ResponseEntity<Board>(board, HttpStatus.OK);
    }

    @DeleteMapping("/modify/{boardNo}")
    public ResponseEntity<Board> deleteBoard(@PathVariable("boardNo") Long boardNo) throws Exception{

        log.info("boardNo() :" + boardNo);

        Optional<Board> board = repository.findById(boardNo);

        board.ifPresent(selectBoard -> {
            repository.delete(selectBoard);
        });

        return new ResponseEntity<Board>(HttpStatus.OK);
    }
}
