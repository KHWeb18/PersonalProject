package com.pettalk.pettalkbackend.constants;

public enum HttpStatus {
    OK(200, "OK"),
    BAD_REQUEST(400, "BAD_REQUEST"),
    UNAUTHORIZED(403, "UNAUTHORIZED"),
    NOT_FOUND(404, "NOT_FOUND"),
    INTERNAL_SERER_ERROR(500, "INTERNAL_SERVER_ERROR");

    int statusCode;
    String code;

    HttpStatus(int statusCode, String code) {
        this.statusCode = statusCode;
        this.code = code;
    }
}
