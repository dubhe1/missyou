package com.missyou.core;

import com.missyou.exception.CreateSuccess;

public class UnifyResponse {
    private final int code;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getRequest() {
        return request;
    }

    private final String message;
    private final String request;

    public UnifyResponse(int code, String message, String request) {
        this.code = code;
        this.message = message;
        this.request = request;
    }

    public static void createSuccess(int code) {
        throw new CreateSuccess(code);
    }
}
