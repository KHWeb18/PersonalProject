package com.example.market3.Controller1;


import com.example.market3.Controller1.MemberRequset.CustomerSoundCommentRequest;
import com.example.market3.Entity.CustomerSound;
import com.example.market3.Service.CustomerSoundService;
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
@RequestMapping("/CustomerSound")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class CustomerSoundController {

    @Autowired
    CustomerSoundService customerSoundService ;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Validated @RequestBody CustomerSound customerSound) throws  Exception {

        customerSoundService.register(customerSound);

        return  new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/getSoundList")
    public ResponseEntity<List<CustomerSound>> getSoundList() throws  Exception {

        customerSoundService.getSoundList();
        return  new ResponseEntity<>(customerSoundService.getSoundList(),HttpStatus.OK);
    }
    @GetMapping("/getSound/{boardNo}")
    public ResponseEntity<CustomerSound> getSound (@PathVariable("boardNo")Long boardNo) throws  Exception {

        Optional<CustomerSound> customerSound = customerSoundService.getSound(boardNo);

        CustomerSound customerSound1 = customerSound.get();


        return new ResponseEntity<>(customerSound1,HttpStatus.OK);
    }
    @PostMapping("/comment/{boardNo}")
    public ResponseEntity<Void> comment(@PathVariable("boardNo")Long boardNo, @Validated @RequestBody CustomerSoundCommentRequest customerSoundCommentRequest) throws Exception  {

        customerSoundCommentRequest.setBoardNo(boardNo);
        customerSoundService.comment(customerSoundCommentRequest);

        return new  ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/vuecount/{boardNo}")
    public  ResponseEntity<Void> vuecount (@PathVariable("boardNo") Long boardNo) throws  Exception {

        customerSoundService.vuecount(boardNo);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/commentModify/{customerSoundBoardNo}")
    public  ResponseEntity<Void> commentModify (@PathVariable("customerSoundBoardNo") Long customerSoundBoardNo,@Validated @RequestBody CustomerSoundCommentRequest customerSoundCommentRequest) throws  Exception {

        String comments = customerSoundCommentRequest.getComments();
        customerSoundService.commentModify(customerSoundBoardNo,comments );
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteComment/{customerSoundBoardNo}")
    public ResponseEntity<Void> deleteComment (@PathVariable("customerSoundBoardNo")Long customerSoundBoardNo) throws  Exception {


        customerSoundService.deleteComment(customerSoundBoardNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
