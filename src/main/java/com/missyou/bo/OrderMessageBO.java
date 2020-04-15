package com.missyou.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderMessageBO {
    private Long orderId;
    private Long couponId;
    private Long userId;
    private String message;

    public OrderMessageBO(String message) {
        this.message = message;
        this.parseId(message);
    }

    private void parseId(String message) {
        String[] temp = message.split(",");
        this.userId = Long.valueOf(temp[0]);
        this.orderId = Long.valueOf(temp[1]);
        this.couponId = Long.valueOf(temp[2]);
    }

}
