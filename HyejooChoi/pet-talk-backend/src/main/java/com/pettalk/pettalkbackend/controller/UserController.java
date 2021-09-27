package com.pettalk.pettalkbackend.controller;

import com.pettalk.pettalkbackend.dto.PetTalkResponse;
import com.pettalk.pettalkbackend.dto.user.LoginRequest;
import com.pettalk.pettalkbackend.dto.user.LoginResponse;
import com.pettalk.pettalkbackend.dto.user.SignUpRequest;
import com.pettalk.pettalkbackend.dto.user.UpdateUserRequest;
import com.pettalk.pettalkbackend.entity.User;
import com.pettalk.pettalkbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 로그인
     * @param loginRequest
     * @return
     */
    @PostMapping("/login")
    public PetTalkResponse<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        PetTalkResponse<LoginResponse> response = new PetTalkResponse<>();
        LoginResponse loginResponse = userService.login(loginRequest);
        response.setData(loginResponse);
        return response;
    }

    /**
     * 회원 가입
     * @param signUpRequest
     * @return
     */
    @PostMapping("/signup")
    public PetTalkResponse<User> signUp(@RequestBody SignUpRequest signUpRequest) {
        PetTalkResponse<User> response = new PetTalkResponse<>();
        User user = userService.signUp(signUpRequest);
        response.setData(user);
        return response;
    }

    /**
     * 회원 정보 조회
     * @param userNo
     * @return
     */
    @GetMapping("/{userNo}")
    public PetTalkResponse<User> getUser(@PathVariable long userNo) {
        PetTalkResponse<User> response = new PetTalkResponse<>();
        User user = userService.getUser(userNo);
        response.setData(user);
        return response;
    }

    /**
     * 회원 정보 수정
     * @param userNo
     * @param updateUserRequest
     * @return
     */
    @PostMapping("/{userNo}")
    public PetTalkResponse<User> updateUser(@PathVariable long userNo, @RequestBody UpdateUserRequest updateUserRequest) {
        PetTalkResponse<User> response = new PetTalkResponse<>();
        User user = userService.getUser(userNo);
        User updateUser = userService.updateUser(user, updateUserRequest);
        response.setData(updateUser);
        return response;
    }
}
