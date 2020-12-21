package com.mayikt.strategy.impl;

import com.mayikt.strategy.PayStrategy;
import org.springframework.stereotype.Component;

@Component
public class WeChatPayStrategy implements PayStrategy {
    @Override
    public String toPayHtml() {
        return "调用微信支付接口。。。";
    }
}
