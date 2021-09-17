package com.example.market3.Controller1;

import com.example.market3.Controller1.MemberRequset.ButterflyCommentRequest;
import com.example.market3.Controller1.MemberRequset.DragonflyCommentRequest;
import com.example.market3.Entity.JpaButterfly;
import com.example.market3.Entity.JpaDragonfly;
import com.example.market3.Entity.JpaDragonflyComment;
import com.example.market3.Rapository.DragonflyCommentRepository;
import com.example.market3.Service.DragonflyService;
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
@RequestMapping("/dragonfly")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class DragonflyController {

    @Autowired
    DragonflyService service;

    @PostMapping("/register")
    public ResponseEntity<Void> register (@Validated @RequestBody JpaDragonfly jpaDragonfly) throws  Exception {

        service.register(jpaDragonfly);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("/dragonflyList")
    public ResponseEntity<List<JpaDragonfly>> getDragonflyList() throws  Exception{


        service.getDragonList();

        return new ResponseEntity<>( service.getDragonList(),HttpStatus.OK);
    }

    @GetMapping("/dragonfly/{boardNo}")
    public ResponseEntity<JpaDragonfly> read (@PathVariable("boardNo")Long boardNo )throws  Exception{

        Optional<JpaDragonfly> jpaDragonfly = service.read(boardNo);

        JpaDragonfly jpaDragonfly1  = jpaDragonfly.get();


                return new ResponseEntity<>(jpaDragonfly1,HttpStatus.OK);
    }

    @PostMapping("/comments/{boardNo}")
    public ResponseEntity<Void> addDragonflyComments(@PathVariable("boardNo") Long boardNo, @Validated @RequestBody DragonflyCommentRequest dragonflyCommentRequest) throws  Exception{

        dragonflyCommentRequest.setBoardNo(boardNo);

        service.addcomments(dragonflyCommentRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/commentList/{boardNo}")
    public  ResponseEntity<List<JpaDragonflyComment>> getDragonflyCommentList(@PathVariable("boardNo")Long boardNo) throws  Exception{


        service.getcomment(boardNo);

        return new ResponseEntity<>( service.getcomment(boardNo),HttpStatus.OK);
    }

    @PostMapping("/vuecount/{boardNo}")
    public ResponseEntity<Void> addvuecount (@PathVariable("boardNo") Long boardNo) throws  Exception {


        service.addvuecount(boardNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/ModifyComments/{boardNo}")
    public  ResponseEntity<Void> ModifyComments(@PathVariable("boardNo") Long boardNo, @Validated @RequestBody DragonflyCommentRequest dragonflyCommentRequest) throws  Exception{
        dragonflyCommentRequest.setBoardNo(boardNo);
        service.ModifyComments(dragonflyCommentRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);

    }

    @DeleteMapping("/deleteComment/{dragonflyCommentNo}")
    public ResponseEntity<Void> deleteComment (@PathVariable("dragonflyCommentNo") Long dragonflyCommentNo) throws  Exception {

        service.deleteComment(dragonflyCommentNo);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/searchtitle")
    public ResponseEntity<JpaDragonfly> searchtitle (@Validated @RequestBody DragonflyCommentRequest dragonflyCommentRequest) throws  Exception {

        try {
            Optional<JpaDragonfly> jpaDragonfly = service.searchtitle(dragonflyCommentRequest);
            JpaDragonfly jpaDragonfly1 = jpaDragonfly.get();

            return new ResponseEntity<>(jpaDragonfly1, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }
    @PostMapping("/Modify/{boardNo}")
    public ResponseEntity<Void> Modify(@PathVariable("boardNo")Long boardNo, @Validated @RequestBody DragonflyCommentRequest dragonflyCommentRequest) throws  Exception {

        String text = dragonflyCommentRequest.getText();
        service.Modify(boardNo, text);
        return new ResponseEntity<Void>(HttpStatus.OK );
    }

}
