package com.pettalk.pettalkbackend.dto.user;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String password;
    private String nickname;
    private String email;
}
