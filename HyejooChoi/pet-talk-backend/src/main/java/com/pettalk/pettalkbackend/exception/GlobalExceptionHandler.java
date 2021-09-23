package com.pettalk.pettalkbackend.exception;

import com.pettalk.pettalkbackend.constants.HttpStatus;
import com.pettalk.pettalkbackend.constants.ResultCode;
import com.pettalk.pettalkbackend.dto.CommonResponse;
import com.pettalk.pettalkbackend.dto.PetTalkResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomAuthenticationException.class)
    protected PetTalkResponse<CommonResponse> handleCustomAuthenticationException(CustomAuthenticationException e) {

        log.info("handleCustomAuthenticationException", e);

        PetTalkResponse<CommonResponse> response = new PetTalkResponse<>();

        response.setData(null);
        response.setResultCode(ResultCode.UNAUTHORIZED);
        response.setMessage("잘못된 JWT 토큰입니다.");

        return response;
    }

    @ExceptionHandler(LoginFailedException.class)
    protected PetTalkResponse<CommonResponse> handleLoginFailedException(LoginFailedException e) {

        log.info("handleLoginFailedException", e);

        PetTalkResponse<CommonResponse> response = new PetTalkResponse<>();

        response.setData(null);
        response.setResultCode(ResultCode.UNAUTHORIZED);
        response.setMessage("잘못된 JWT 토큰입니다.");

        return response;
    }

    @ExceptionHandler(CustomJwtRuntimeException.class)
    protected PetTalkResponse<CommonResponse> handleJwtException(CustomJwtRuntimeException e) {

        log.info("handleJwtException", e);

        PetTalkResponse<CommonResponse> response = new PetTalkResponse<>();

        response.setData(null);
        response.setResultCode(ResultCode.UNAUTHORIZED);
        response.setMessage("잘못된 JWT 토큰입니다.");

        return response;
    }
}