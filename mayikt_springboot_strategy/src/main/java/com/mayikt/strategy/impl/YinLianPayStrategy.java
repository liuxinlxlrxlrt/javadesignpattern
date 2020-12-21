package com.mayikt.strategy.impl;

import com.mayikt.strategy.PayStrategy;
import org.springframework.stereotype.Component;

@Component
public class YinLianPayStrategy implements PayStrategy {
    @Override
    public String toPayHtml() {
        return "调用银联支付接口。。。";
    }
}
