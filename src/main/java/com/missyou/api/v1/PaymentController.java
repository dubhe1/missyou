package com.missyou.api.v1;

import com.missyou.core.interceptors.ScopeLevel;
import com.missyou.lib.LinWxNotify;
import com.missyou.service.WxPaymentNotifyService;
import com.missyou.service.WxPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Positive;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@RequestMapping("payment")
@RestController
@Validated
public class PaymentController {

    @Autowired
    private WxPaymentService wxPaymentService;

    @Autowired
    private WxPaymentNotifyService wxPaymentNotifyService;


    @PostMapping("/pay/order/{id}")
    @ScopeLevel
    public Map<String, String> preWxOrder(@PathVariable(name = "id") @Positive Long oid) {
        return this.wxPaymentService.preOrder(oid);
    }


    @RequestMapping("/wx/notify")
    public String payCallback(HttpServletRequest request,
                              HttpServletResponse response) {
        InputStream s;
        try {
            s = request.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return LinWxNotify.fail();
        }
        String xml;
        xml = LinWxNotify.readNotify(s);
        try {
            this.wxPaymentNotifyService.processPayNotify(xml);
        } catch (Exception e) {
            return LinWxNotify.fail();
        }
        return LinWxNotify.success();
    }
}
