package com.github.wxpay.sdk;

import java.io.InputStream;

public class LWxPayConfig extends WXPayConfig {
    public String getAppID() {
        return "wx4xxxxxxx";
    }

    public String getMchID() {
        return "1589111117";
    }

    public String getKey() {
        return "yDDDsDv6kFG1qXXX6jP";
    }

    public InputStream getCertStream() {
        return null;
    }

    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    public IWXPayDomain getWXPayDomain(){
        return null;
    }

}
