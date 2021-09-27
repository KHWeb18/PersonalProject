package com.example.market3.Controller1;

import com.example.market3.Controller1.MemberRequset.ButterflyCommentRequest;
import com.example.market3.Controller1.MemberRequset.SkycowCommentRequest;
import com.example.market3.Entity.JpaButterfly;
import com.example.market3.Entity.JpaSkycow;
import com.example.market3.Entity.JpaSkycowComment;
import com.example.market3.Service.SkycowService;
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
@RequestMapping("/skycow")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class JpaSkycowController {

    @Autowired
    SkycowService skycowService;

    @PostMapping("/register")
    public ResponseEntity<Void> register (@Validated @RequestBody JpaSkycow jpaSkycow) throws  Exception {


        skycowService.register(jpaSkycow);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("/SkycowList")
    public ResponseEntity<List<JpaSkycow>> getSkycowList () throws Exception {

        skycowService.getSkycowlist();

        return new ResponseEntity<>(skycowService.getSkycowlist(),HttpStatus.OK);
    }
    @GetMapping("/skycow/{boardNo}")
    public  ResponseEntity<JpaSkycow> getSkycow (@PathVariable("boardNo")Long boardNo) throws  Exception {

        Optional<JpaSkycow> jpaSkycow = skycowService.getSkycow(boardNo);
        JpaSkycow jpaSkycow1 = jpaSkycow.get();

        return new ResponseEntity<>(jpaSkycow1,HttpStatus.OK);

    }
    @PostMapping("/comments/{boardNo}")
    public ResponseEntity<Void> comments (@PathVariable("boardNo")Long boardNo, @Validated @RequestBody SkycowCommentRequest skycowCommentRequest) throws  Exception {


        skycowCommentRequest.setBoardNo(boardNo);
        skycowService.comments(skycowCommentRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PostMapping("/vuecount/{boardNo}")
    public ResponseEntity<Void> vuecount(@PathVariable("boardNo")Long boardNo) throws  Exception {

        skycowService.vuecount(boardNo);

        return new ResponseEntity<Void>( HttpStatus.OK);
    }

    @PostMapping("/ModifyComments/{boardNo}")
    public ResponseEntity<Void> ModifyComments(@PathVariable("boardNo")Long boardNo ,@Validated @RequestBody SkycowCommentRequest skycowCommentRequest) throws  Exception {
        skycowCommentRequest.setBoardNo(boardNo);
        skycowService.ModifyComments(skycowCommentRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteComment/{skycowCommentsNo}")
    public  ResponseEntity<Void> deleteComment (@PathVariable("skycowCommentsNo") Long skycowCommentsNo) throws  Exception {

        skycowService.deleteComment(skycowCommentsNo);
        return new ResponseEntity<Void>(HttpStatus.OK );
    }

    @PostMapping("/searchtitle")
    public ResponseEntity<JpaSkycow> searchtitle (@Validated @RequestBody SkycowCommentRequest skycowCommentRequest) throws  Exception {

        try {
            Optional<JpaSkycow> jpaSkycow = skycowService.searchtitle(skycowCommentRequest);
            JpaSkycow jpaSkycow1 = jpaSkycow.get();

            return new ResponseEntity<>(jpaSkycow1, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @PostMapping("Modify/{boardNo}")
    public  ResponseEntity<Void> Modify (@PathVariable("boardNo")Long boardNo, @Validated @RequestBody SkycowCommentRequest skycowCommentRequest) throws  Exception {

            String text = skycowCommentRequest.getText();
        skycowService.Modify(boardNo,text);

        return  new ResponseEntity<Void>(HttpStatus.OK );
    }
}
