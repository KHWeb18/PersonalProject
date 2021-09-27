package com.example.demo.controller.member.request;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {
    private String userId;
    private String password;
    private String auth;

    public MemberRequest(String userId, String password, String auth) {
        this.userId = userId;
        this.password = password;
        this.auth = auth;
    }


}
