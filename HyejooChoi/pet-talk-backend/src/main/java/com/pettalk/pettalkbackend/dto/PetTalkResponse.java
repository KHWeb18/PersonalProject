package com.pettalk.pettalkbackend.dto;

import com.pettalk.pettalkbackend.constants.ResultCode;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class PetTalkResponse<T> {
    private String message;
    private ResultCode resultCode = ResultCode.SUCCESS;
    private T data;

    public PetTalkResponse() {
        this.message = "성공";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
