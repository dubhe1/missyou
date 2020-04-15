package com.missyou.service;

import com.missyou.bo.OrderMessageBO;
import com.missyou.core.enumeration.OrderStatus;
import com.missyou.exception.http.ServerErrorException;
import com.missyou.model.Order;
import com.missyou.repository.OrderRepository;
import com.missyou.repository.UserCouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CouponBackService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserCouponRepository userCouponRepository;

    @Transactional
    public void returnBack(OrderMessageBO bo) {
        Long couponId = bo.getCouponId();
        Long uid = bo.getUserId();
        Long orderId = bo.getOrderId();

        if (couponId == -1) {
            return;
        }

        Optional<Order> optional = orderRepository.findFirstByUserIdAndId(uid, orderId);
        Order order = optional.orElseThrow(() -> new ServerErrorException(9999));

        if (order.getStatusEnum().equals(OrderStatus.UNPAID)
                || order.getStatusEnum().equals(OrderStatus.CANCELED)) {
            this.userCouponRepository.returnBack(couponId, uid);
        }
    }
}
