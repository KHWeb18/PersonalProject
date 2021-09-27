package com.example.market3.Controller1;

import com.example.market3.Controller1.MemberRequset.BoardRequest;
import com.example.market3.Entity.JpaBoard;
import com.example.market3.Entity.JpaBoardComment;
import com.example.market3.Service.JpaBoardService;
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
@RequestMapping("/jpaBoard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class JpaBoardController {

    @Autowired
    JpaBoardService service;

    @PostMapping("/register")
    public ResponseEntity<JpaBoard> registermembers(@Validated @RequestBody JpaBoard jpaBoard) throws Exception {
        log.info("post register request from vue");

        service.register(jpaBoard);

        return new ResponseEntity<>(jpaBoard, HttpStatus.OK);
    }

    @GetMapping("/boardlists")
    public ResponseEntity<List<JpaBoard>> getListsBoards () throws Exception {
        log.info("getLists(): " + service.boardlist());

        return new ResponseEntity<>(service.boardlist(), HttpStatus.OK);
    }
    @GetMapping("/{boardNo}")
    public ResponseEntity<JpaBoard> read(@PathVariable("boardNo") Long boardNo) throws Exception {
        Optional<JpaBoard> jpaBoard = service.read(boardNo);
        JpaBoard jpaBoard1 = jpaBoard.get();
        log.info("jpa" + jpaBoard1);
        return new ResponseEntity<JpaBoard>(jpaBoard1, HttpStatus.OK);
    }

    @PostMapping("/comment/{boardNo}")
    public ResponseEntity<Void> commanents(@PathVariable("boardNo") Long boardNo,
                                                  @Validated @RequestBody BoardRequest boardRequest) throws Exception {

            boardRequest.setBoardNo(boardNo);

        service.commanents(boardRequest);

        return new ResponseEntity<Void>( HttpStatus.OK);

    }
    @GetMapping("/Commentslist/{boardNo}")
    public ResponseEntity<List<JpaBoardComment>> getcommentlist (@PathVariable("boardNo") Long boardNo) throws Exception {


      //  service.finByComments2(boardNo);
        service.finByComments(boardNo);


       return new ResponseEntity<>(service.finByComments(boardNo),HttpStatus.OK);

    }

    @PostMapping("/Modify/{boardNo}")
    public ResponseEntity<Void> CommunityModify(@PathVariable("boardNo") Long boardNo,
                                           @Validated @RequestBody JpaBoard jpaBoard) throws Exception {


        String text = jpaBoard.getText();

        service.CommunityModify(boardNo,text);

        return new ResponseEntity<Void>( HttpStatus.OK);

    }

    @DeleteMapping("{boardNo}")
    public ResponseEntity<Void> remove(@PathVariable Long boardNo) throws Exception{

        service.remove(boardNo);

        return new ResponseEntity<Void>( HttpStatus.OK);
    }
    @PostMapping({"/vuecount/{boardNo}"})
    public ResponseEntity<Void> vuecountupdate(@PathVariable("boardNo") Long boardNo) throws  Exception{

        service.vuecountupdate(boardNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PostMapping("/ModifyComments/{boardNo}")
    public ResponseEntity<Void> commentModify(@PathVariable("boardNo")Long boardNo,@Validated @RequestBody BoardRequest boardRequest ) throws  Exception{

        boardRequest.setBoardNo(boardNo);
        System.out.println(boardRequest.getBoardNo());
        System.out.println(boardRequest.getUi());
        System.out.println(boardRequest.getComments());
        System.out.println(boardRequest.getBoardCommentNo());
        service.commentModify(boardRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);

    }

    @DeleteMapping("/deleteComment/{boardCommentNo}")
    public ResponseEntity<Void> removeComment (@PathVariable Long boardCommentNo) throws  Exception{

       service.removeComment(boardCommentNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }



}
