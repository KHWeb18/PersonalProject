package com.pettalk.pettalkbackend.constants;

import lombok.Getter;
import lombok.ToString;

import javax.servlet.http.HttpServletResponse;

/**
 * HTTP 응답 코드
 */
@Getter
@ToString
public enum ResultCode {
    SUCCESS (HttpServletResponse.SC_OK, "성공"),
    NOT_LOGINED (HttpServletResponse.SC_UNAUTHORIZED, "로그인 상태가 아닙니다."),
    CANNOT_FIND (HttpServletResponse.SC_CONFLICT, "찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR (HttpServletResponse.SC_CONFLICT, "서버 오류입니다."),
    UNAUTHORIZED (HttpServletResponse.SC_UNAUTHORIZED, "권한이 없습니다.");

    private int httpStatusCode;
    private String message;

    ResultCode(int httpStatusCode, String message) {
        this.httpStatusCode = httpStatusCode;
        this.message = message;
    }

    public String getHttpStatusCode() {
        return Integer.toString(this.httpStatusCode);
    }
}
