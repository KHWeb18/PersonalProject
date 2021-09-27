package com.example.Mini.controller.member.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {
    private String userId;
    private String password;
    private String nickname;
    private String auth;
    private Long memberNo;
    private Date regDate;
}