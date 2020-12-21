package com.mayikt.strategy.impl;

import com.mayikt.strategy.PayStrategy;
import org.springframework.stereotype.Component;

@Component
public class AliPayStrategy implements PayStrategy {

    //<bean id="aliPayStrategy" class="com.mayikt.strategy.impl.AliPayStrategy">
    //使用类名小写名称，从spring容器中获取具体策略对象

    @Override
    public String toPayHtml() {
        return "调用支付宝的接口。。。";
    }
}
