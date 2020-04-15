package com.missyou.service;

import com.missyou.bo.OrderMessageBO;

public interface OrderCancelService {

    public void cancel(OrderMessageBO messageBO);

    public void cancel(Long oid);
}
