package com.missyou.exception.http;

public class HttpException extends RuntimeException {
    protected Integer code;

    public Integer getCode() {
        return code;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    protected Integer httpStatusCode = 500;
}
