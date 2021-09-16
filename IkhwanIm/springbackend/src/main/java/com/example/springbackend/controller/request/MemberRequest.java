package com.example.springbackend.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {
    private String member_id;
    private String member_pw;
    private String name;
    private String email;

}
