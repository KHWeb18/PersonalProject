package com.example.market3.Controller1;

import com.example.market3.Controller1.MemberRequset.BeetleCommentRequest;
import com.example.market3.Controller1.MemberRequset.ButterflyCommentRequest;
import com.example.market3.Entity.JpaBeetle;
import com.example.market3.Entity.JpaButterfly;
import com.example.market3.Service.ButterflyService;
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
@RequestMapping("/butterfly")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class ButterflyController {

    @Autowired
    ButterflyService butterflyService;

        @PostMapping("register")
    public ResponseEntity<Void> register(@Validated @RequestBody JpaButterfly jpaButterfly) throws  Exception {

            butterflyService.register(jpaButterfly);


            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    @GetMapping("/butterflyList")
    public ResponseEntity<List<JpaButterfly>> getButterflyList () throws Exception{

        butterflyService.getlist();


        return new ResponseEntity<>(butterflyService.getlist(),HttpStatus.OK);
    }

    @GetMapping("/butterfly/{boardNo}")
    public ResponseEntity<JpaButterfly> getButterfly(@PathVariable("boardNo")Long boardNo) throws  Exception {

        Optional<JpaButterfly> jpaButterfly = butterflyService.getButterfly(boardNo);

        JpaButterfly jpaButterfly1 = jpaButterfly.get();

        return new ResponseEntity<>(jpaButterfly1, HttpStatus.OK);
    }
    @PostMapping("/vuecount/{boardNo}")
    public ResponseEntity<Void> vuecount(@PathVariable("boardNo")Long boardNo)throws  Exception{

        butterflyService.vuecount(boardNo);
            return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/comments/{boardNo}")
    public ResponseEntity<Void> comments (@PathVariable("boardNo")Long boardNo, @Validated @RequestBody ButterflyCommentRequest butterflyCommentRequest) throws  Exception {
        butterflyCommentRequest.setBoardNo(boardNo);

        butterflyService.comments(butterflyCommentRequest);
            return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/ModifyComments/{boardNo}")
    public ResponseEntity<Void> ModifyComments(@PathVariable("boardNo")Long boardNo ,@Validated @RequestBody ButterflyCommentRequest butterflyCommentRequest ) throws  Exception {
        butterflyCommentRequest.setBoardNo(boardNo);
        butterflyService.ModifyComments(butterflyCommentRequest);
            return new ResponseEntity<Void>( HttpStatus.OK);
    }

    @DeleteMapping("/deleteComment/{butterflyCommentNo}")
    public  ResponseEntity<Void> deleteComment(@PathVariable("butterflyCommentNo") Long butterflyCommentNo) throws  Exception {

        butterflyService.deleteComment(butterflyCommentNo);
            return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/searchtitle")
    public ResponseEntity<JpaButterfly> searchtitle (@Validated @RequestBody ButterflyCommentRequest butterflyCommentRequest) throws  Exception {

        try {
            Optional<JpaButterfly> jpaButterfly = butterflyService.searchtitle(butterflyCommentRequest);
            JpaButterfly jpaButterfly1 = jpaButterfly.get();

            return new ResponseEntity<>(jpaButterfly1, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }
    @PostMapping("/Modify/{boardNo}")
    public  ResponseEntity<Void> Modify(@PathVariable("boardNo")Long boardNo , @Validated @RequestBody ButterflyCommentRequest  butterflyCommentRequest ) throws  Exception {

            String text = butterflyCommentRequest.getText();

        butterflyService.Modify(boardNo,text);


            return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
