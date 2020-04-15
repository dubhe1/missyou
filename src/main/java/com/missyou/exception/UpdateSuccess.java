package com.missyou.exception;

import com.missyou.exception.http.HttpException;

public class UpdateSuccess extends HttpException {
    public UpdateSuccess(int code){
        this.httpStatusCode = 200;
        this.code = code;
    }
}
