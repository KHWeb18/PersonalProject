package com.pettalk.pettalkbackend.exception;

import com.pettalk.pettalkbackend.constants.ResultCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.NestedRuntimeException;

@Getter
@Setter
public class PetTalkException extends NestedRuntimeException {
    private String message;
    private ResultCode resultCode;
    private Object data;

    public PetTalkException(String message, ResultCode resultCode, Object data) {
        super(message);
        this.message = message;
        this.resultCode = resultCode;
        this.data = data;
    }
}
