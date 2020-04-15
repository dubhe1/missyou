package com.missyou.exception;

import com.missyou.exception.http.HttpException;

public class DeleteSuccess extends HttpException {
    public DeleteSuccess(int code){
        this.httpStatusCode = 200;
        this.code = code;
    }
}
