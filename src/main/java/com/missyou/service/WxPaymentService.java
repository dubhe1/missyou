package com.missyou.service;

import com.github.wxpay.sdk.*;

import java.util.Map;


public interface WxPaymentService {

    public Map<String, String> preOrder(Long oid);

    public WXPay assembleWxPayConfig();
}
