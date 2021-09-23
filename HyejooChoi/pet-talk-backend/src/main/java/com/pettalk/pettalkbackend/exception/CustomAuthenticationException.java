package com.pettalk.pettalkbackend.exception;

import com.pettalk.pettalkbackend.constants.ResultCode;

public class CustomAuthenticationException extends RuntimeException {

    public CustomAuthenticationException(){
        super(ResultCode.UNAUTHORIZED.getMessage());
    }

    public CustomAuthenticationException(Exception ex){
        super(ex);
    }
}