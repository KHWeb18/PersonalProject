package com.pettalk.pettalkbackend.dto.user;

import lombok.Data;

@Data
public class SignUpRequest {
    private String userId;
    private String password;
    private String nickname;
    private String email;
}
