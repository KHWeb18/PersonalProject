package com.pettalk.pettalkbackend.exception;

import com.pettalk.pettalkbackend.constants.ResultCode;

public class LoginFailedException extends RuntimeException {

    public LoginFailedException(){
        super(ResultCode.NOT_LOGINED.getMessage());
    }

    private LoginFailedException(String msg){
        super(msg);
    }
}