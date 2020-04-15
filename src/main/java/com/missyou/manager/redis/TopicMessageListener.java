package com.missyou.manager.redis;

import com.missyou.bo.OrderMessageBO;
import com.missyou.service.CouponBackService;
import com.missyou.service.OrderCancelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class TopicMessageListener implements MessageListener {

    @Autowired
    private OrderCancelService orderCancelService;

    @Autowired
    private CouponBackService couponBackService;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] body = message.getBody();
        byte[] channel = message.getChannel();

        String expiredKey = new String(body);
        String topic = new String(channel);

        OrderMessageBO messageBO = new OrderMessageBO(expiredKey);
        orderCancelService.cancel(messageBO);
        couponBackService.returnBack(messageBO);
    }
}
