package com.pettalk.pettalkbackend.dto.user;

import lombok.Data;

@Data
public class LoginRequest {
    private String loginId;
    private String password;
}
