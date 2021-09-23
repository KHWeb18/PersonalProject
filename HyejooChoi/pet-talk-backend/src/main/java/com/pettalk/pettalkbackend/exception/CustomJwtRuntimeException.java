package com.pettalk.pettalkbackend.exception;

import com.pettalk.pettalkbackend.constants.ResultCode;

public class CustomJwtRuntimeException extends RuntimeException {

    public CustomJwtRuntimeException(){
        super(ResultCode.UNAUTHORIZED.getMessage());
    }

    public CustomJwtRuntimeException(Exception ex){
        super(ex);
    }
}
