package com.mayikt.strategy.impl;

import com.mayikt.strategy.PayStrategy;
import org.springframework.stereotype.Component;

@Component
public class XiaoMiPayStrategy implements PayStrategy {
    @Override
    public String toPayHtml() {
        return "调用小米支付接口。。。";
    }
}
