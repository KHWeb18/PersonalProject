package com.example.demo_ver.controller.vue.jpa;


import com.example.demo_ver.entity.jpa.SecondBoard;
import com.example.demo_ver.service.jpa.SecondBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/secondboard")
@CrossOrigin(origins = "http://localhost:8080",allowedHeaders = "*")
public class JPASecondBoardController {

    @Autowired
    private SecondBoardService service;
    @PostMapping("/register")
    public ResponseEntity<SecondBoard> getRegister(@Validated @RequestBody SecondBoard board) throws Exception {
        service.register(board);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }
}
