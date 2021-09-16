package com.example.project1.controller.jpa.request;


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
    private String name;
    private String phoneNo;
    private String address;
    private String email;


}
