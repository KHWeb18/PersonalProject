package com.example.Mini.controller.member.session;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long memberNo;
    private String userId;
    private String auth;
    private String nickname;
    private Date regDage;
}
