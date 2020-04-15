package com.missyou.core.enumeration;


public enum LoginType {
    USER_WX(0, "微信登录"),
    USER_Email(1, "邮箱登录");

    private final Integer value;
    private final String description;

    LoginType(Integer value, String description) {
        this.value = value;
        this.description = description;
    }
}
