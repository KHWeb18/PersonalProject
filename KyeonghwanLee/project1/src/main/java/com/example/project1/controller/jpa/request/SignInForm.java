package com.example.project1.controller.jpa.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SignInForm {

    private String email;
    private String password;

    public SignInRequest toSignInRequest() {
        return new SignInRequest(email, password);
    }
}