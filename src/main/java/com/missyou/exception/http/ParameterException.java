package com.missyou.exception.http;

public class ParameterException extends HttpException {
    public ParameterException(int code){
        this.code = code;
        this.httpStatusCode = 400;
    }
}
