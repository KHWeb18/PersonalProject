package com.pettalk.pettalkbackend.controller;

import com.pettalk.pettalkbackend.constants.ResultCode;
import com.pettalk.pettalkbackend.dto.PetTalkResponse;
import com.pettalk.pettalkbackend.exception.PetTalkException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class ErrorController {
    /**
     * 일반 Exception이 발생한 경우 처리
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public PetTalkResponse<Object> handleInternalServerException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        PetTalkResponse<Object> petTalkResponse = new PetTalkResponse<>();
        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        petTalkResponse.setMessage("Internal Server Error");
        petTalkResponse.setResultCode(ResultCode.INTERNAL_SERVER_ERROR);
        return petTalkResponse;
    }

    /**
     * PetTalkException이 발생한 경우 처리
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(PetTalkException.class)
    public PetTalkResponse<Object> handleException(PetTalkException ex, HttpServletRequest request, HttpServletResponse response) {
        PetTalkResponse<Object> petTalkResponse = new PetTalkResponse<>();
        log.error("errorMessage: {}",ex);
        response.setContentType("application/json;charset=UTF-8");
        petTalkResponse.setMessage(ex.getMessage());
        petTalkResponse.setResultCode(ex.getResultCode());
        petTalkResponse.setData(ex.getData());
        return petTalkResponse;
    }
}