package com.missyou.service;

import com.missyou.dto.OrderDTO;

import com.missyou.logic.OrderChecker;
import com.missyou.model.*;

import org.springframework.data.domain.Page;

import java.util.Optional;


public interface OrderService {
    public Long placeOrder(Long uid, OrderDTO orderDTO, OrderChecker orderChecker);

    public Page<Order> getUnpaid(Integer page, Integer size);

    public Page<Order> getByStatus(Integer status, Integer page, Integer size);

    public Optional<Order> getOrderDetail(Long oid);

    public void updateOrderPrepayId(Long orderId, String prePayId);

    public OrderChecker isOk(Long uid, OrderDTO orderDTO);
}
