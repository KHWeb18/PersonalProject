package com.example.writer.controller;

import com.example.writer.entity.User;
import com.example.writer.repository.UserRepository;
import com.example.writer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user-register")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")

public class UserRegisterPageController {


    @Autowired
    UserService service;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<Boolean> userRegister(@RequestBody User user) throws Exception {
        log.info("user-register(): "+user.getEmail()+user.getName()+user.getPw());

        boolean isSuccess = service.register(user);


        return new ResponseEntity<Boolean>(isSuccess,HttpStatus.OK);
    }







}
