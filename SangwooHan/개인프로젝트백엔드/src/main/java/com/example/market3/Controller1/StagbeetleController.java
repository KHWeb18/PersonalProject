package com.example.market3.Controller1;


import com.example.market3.Controller1.MemberRequset.StagbeetleCommentRuquest;
import com.example.market3.Entity.JpaNotice;
import com.example.market3.Entity.JpaStagbeetle;
import com.example.market3.Entity.JpaStagbeetleComment;
import com.example.market3.Service.StagbeetleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/stagbeetle")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class StagbeetleController {

    @Autowired
    StagbeetleService service;

    @PostMapping("/register")
    public ResponseEntity<JpaStagbeetle> registermembers(@Validated @RequestBody JpaStagbeetle jpaStagbeetle) throws Exception {
        log.info("post register request from vue");

        service.register(jpaStagbeetle);

        return new ResponseEntity<>(jpaStagbeetle, HttpStatus.OK);
    }

    @GetMapping("/stagbeetleList")
    public ResponseEntity<List<JpaStagbeetle>> getStagbeetleList () throws  Exception{
        
        service.StagbeetleList();
        
        return  new ResponseEntity<>(service.StagbeetleList(),HttpStatus.OK);
    }
    @GetMapping("/stagbeetle/{boardNo}")
    public ResponseEntity<JpaStagbeetle> read(@PathVariable("boardNo") Long boardNo) throws Exception {
        Optional<JpaStagbeetle> jpaStagbeetle = service.read(boardNo);
        JpaStagbeetle jpaStagbeetle1 = jpaStagbeetle.get();
        log.info("jpa" + jpaStagbeetle1);
        return new ResponseEntity<JpaStagbeetle>(jpaStagbeetle1, HttpStatus.OK);
    }

    @PostMapping("/comments/{boardNo}")
    public ResponseEntity<Void> StagbeetleComment(@PathVariable("boardNo") Long boardNo, @Validated @RequestBody StagbeetleCommentRuquest stagbeetleCommentRuquest) throws  Exception {

        stagbeetleCommentRuquest.setBoardNo(boardNo);

        service.addComment(stagbeetleCommentRuquest);


        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("/stagbeetleComment/{boardNo}")
    public ResponseEntity<List<JpaStagbeetleComment>> pushStagbeetleCommentList(@PathVariable("boardNo") Long boardNo) throws  Exception{

        service.finyByCommentList(boardNo);
        return new ResponseEntity<>(service.finyByCommentList(boardNo),HttpStatus.OK);
    }
    @PostMapping("/vuecount/{boardNo}")
    public ResponseEntity<Void> addvueCount (@PathVariable("boardNo") Long boardNo)throws  Exception {

        service.addvueCount(boardNo);

        return new ResponseEntity<Void>( HttpStatus.OK);
    }

    @PostMapping("/ModifyComments/{boardNo}")
    public ResponseEntity<Void> ModifyComments(@PathVariable("boardNo")Long boardNo, @Validated @RequestBody StagbeetleCommentRuquest stagbeetleCommentRuquest) throws  Exception {

        stagbeetleCommentRuquest.setBoardNo(boardNo);
        service.ModifyComments(stagbeetleCommentRuquest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteComment/{StagbeetleCommentNo}")
    public ResponseEntity<Void> deleteComment(@PathVariable("StagbeetleCommentNo")Long StagbeetleCommentNo) throws  Exception{

        service.deleteComment(StagbeetleCommentNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PostMapping("/searchtitle")
    public ResponseEntity<JpaStagbeetle> searchtitle (@Validated @RequestBody StagbeetleCommentRuquest stagbeetleCommentRuquest) throws  Exception {

        try {
            Optional<JpaStagbeetle> jpaStagbeetle = service.searchtitle(stagbeetleCommentRuquest);
            JpaStagbeetle jpaStagbeetle1 = jpaStagbeetle.get();

            return new ResponseEntity<>(jpaStagbeetle1, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @PostMapping("/Modify/{boardNo}")
    public  ResponseEntity<Void> Modify(@PathVariable("boardNo")Long boardNo, @Validated @RequestBody StagbeetleCommentRuquest stagbeetleCommentRuquest) throws  Exception {

        String text = stagbeetleCommentRuquest.getText();

        service.Modify(boardNo,text);

        return  new ResponseEntity<Void>(HttpStatus.OK );
    }

}
