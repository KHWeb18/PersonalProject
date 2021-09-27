package com.example.demo.controller.authentication.session;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;
    private Integer errorMessage;
    private String name;
    private String team;
    private String auth;
    private Long empNo;
}
