package com.example.writer.controller;


import com.example.writer.controller.session.UserInfo;
import com.example.writer.entity.User;
import com.example.writer.repository.UserRepository;
import com.example.writer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/user-login")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class UserLoginPageController {

    @Autowired
    UserService service;

    @Autowired
    UserRepository repository;

    private UserInfo info;
    private HttpSession session;

    @PostMapping("/login")
    public ResponseEntity<Integer> userLogin(@RequestBody User user) throws Exception{

        log.info("userLogin()! -- Email: "+ user.getEmail()+" ,pw: "+user.getPw());

        Integer res = service.login(user);

        return new ResponseEntity<Integer>(res,HttpStatus.OK);

        //서비스에서 처리하는 더좋은방법이 있지않을까?
        /*
        User maybeUser = repository.findByEmail(user.getEmail());

        if(maybeUser == null){
            log.info("login() - email is not correct");
            return new ResponseEntity<Integer>(1,HttpStatus.OK);
        }

        User loginUser = maybeUser;

        if(!p)

        else{
            log.info("userPw:" +user.getPw());
            log.info("maybeUserPw:"+ maybeUser.getPw());
            if(user.getPw().equals(maybeUser.getPw())){
                log.info("login() success");
                return new ResponseEntity<Integer>(2,HttpStatus.OK);
            }
            else{
                log.info("login() - pw is not correct");
                return new ResponseEntity<Integer>(3,HttpStatus.OK);
            }

         */


    }

    @PostMapping("/needSession")
    public ResponseEntity<UserInfo> needSession(
            @RequestBody User user,
            HttpServletRequest request) throws Exception{

        log.info("session complete() "+ user.getEmail());

        info = new UserInfo();
        info.setEmail(user.getEmail());
        log.info("Session Info: "+info);

        session = request.getSession();
        session.setAttribute("user",info);

        return new ResponseEntity<UserInfo>(info,HttpStatus.OK);
    }

    @PostMapping("/showSession")
    public ResponseEntity<Boolean> postShowSession(HttpServletRequest request) throws Exception{

        Object obj = session.getAttribute("user");

        Boolean isLogin = false;
        if(obj != null){
            log.info("Session Info: "+info);

            isLogin = service.checkUserIdValidation(info.getEmail());

            return new ResponseEntity<Boolean>(isLogin,HttpStatus.OK);
        }
        return new ResponseEntity<Boolean>(isLogin,HttpStatus.OK);
    }

    @PostMapping("/removeSession")
    public ResponseEntity<Boolean> removeSession(HttpServletRequest request) throws Exception {
        Boolean mustFalse = false;

        session.invalidate();

        return new ResponseEntity<Boolean>(mustFalse, HttpStatus.OK);
    }






}
