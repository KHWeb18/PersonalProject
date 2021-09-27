package com.example.market3.Controller1;

import com.example.market3.Entity.Signup;
import com.example.market3.Service.VueSignupService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/vuesignup")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueSignController {

    @Autowired
    private VueSignupService service;

    @PostMapping("/register")
    public ResponseEntity<Signup> registerMonster(@Validated @RequestBody Signup signup) throws Exception {
        log.info("post register request from vue");

        service.register(signup);

        return new ResponseEntity<>(signup, HttpStatus.OK);
    }
    @GetMapping("/lists")
    public ResponseEntity<List<Signup>> getListsMember()throws  Exception{
        log.info("getLists():" + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }


}