package com.example.MiniProject.controller.member;

import com.example.MiniProject.entity.member.Member;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {
    private String email;
    private String userName;
    private String password;
    private String passwordConfirm;
    private String auth;

}
