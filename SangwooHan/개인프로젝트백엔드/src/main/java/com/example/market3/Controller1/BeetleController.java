package com.example.market3.Controller1;

import com.example.market3.Controller1.MemberRequset.BeetleCommentRequest;
import com.example.market3.Controller1.MemberRequset.StagbeetleCommentRuquest;
import com.example.market3.Entity.JpaBeetle;
import com.example.market3.Entity.JpaBeetleComment;
import com.example.market3.Entity.JpaStagbeetle;
import com.example.market3.Entity.JpaStagbeetleComment;
import com.example.market3.Service.BeetleService;
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
@RequestMapping("/beetle")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class BeetleController {

    @Autowired
    BeetleService service;

    @PostMapping("/register")
    public ResponseEntity<JpaBeetle> addBeetle(@Validated @RequestBody JpaBeetle jpabeetle) throws  Exception {

        service.addBeetle(jpabeetle);
        return new ResponseEntity<>(jpabeetle,HttpStatus.OK);
    }

    @GetMapping("/beetlelist")
    public ResponseEntity<List<JpaBeetle>> getBeetleList() throws Exception {

        service.BeetleList();

        return new ResponseEntity<>(service.BeetleList(),HttpStatus.OK);
    }
    @GetMapping("/beetle/{boardNo}")
    public ResponseEntity<JpaBeetle> read(@PathVariable("boardNo") Long boardNo) throws  Exception {

        Optional<JpaBeetle> jpaBeetle =  service.read(boardNo);

        JpaBeetle jpaBeetle1 = jpaBeetle.get();

        return new ResponseEntity<>(jpaBeetle1,HttpStatus.OK);
    }
    @PostMapping("/comments/{boardNo}")
    public ResponseEntity<Void> beetleComment(@PathVariable("boardNo") Long boardNo, @Validated @RequestBody BeetleCommentRequest beetleCommentRequest) throws  Exception {

        beetleCommentRequest.setBoardNo(boardNo);

        service.addComment(beetleCommentRequest);


        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("/beetleCommentList/{boardNo}")
    public ResponseEntity<List<JpaBeetleComment>> getbeetleCommentList(@PathVariable("boardNo") Long boardNo) throws  Exception{

        service.finyByCommentList(boardNo);
        return new ResponseEntity<>(service.finyByCommentList(boardNo),HttpStatus.OK);
    }
    @PostMapping("/vuecount/{boardNo}")
    public ResponseEntity<Void> addvueCount (@PathVariable("boardNo") Long boardNo)throws  Exception {

        service.addvueCount(boardNo);

        return new ResponseEntity<Void>( HttpStatus.OK);
    }

    @PostMapping("/ModifyComments/{boardNo}")
        public ResponseEntity<Void> ModifyComment(@PathVariable("boardNo") Long boardNo, @Validated @RequestBody BeetleCommentRequest beetleCommentRequest ) throws  Exception{

            beetleCommentRequest.setBoardNo(boardNo);

            service.ModifyComment(beetleCommentRequest);


            return  new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteComment/{beetleCommentNo}")
    public  ResponseEntity<Void> DeleteComment (@PathVariable("beetleCommentNo")Long beetleCommentNo)throws  Exception{

        service.DeleteComment(beetleCommentNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/searchtitle")
    public ResponseEntity<JpaBeetle> searchtitle (@Validated @RequestBody BeetleCommentRequest beetleCommentRequest) throws  Exception {

        try {
            Optional<JpaBeetle> jpaBeetle = service.searchtitle(beetleCommentRequest);
            JpaBeetle jpaBeetle1 = jpaBeetle.get();

            return new ResponseEntity<>(jpaBeetle1, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @PostMapping("/Modify/{boardNo}")
    public  ResponseEntity<Void> Modify(@PathVariable("boardNo")Long boardNo, @Validated @RequestBody BeetleCommentRequest beetleCommentRequest) throws  Exception {

        String text = beetleCommentRequest.getText();

        service.Modify(boardNo ,text);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }




}
