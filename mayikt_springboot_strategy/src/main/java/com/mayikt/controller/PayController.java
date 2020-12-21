package com.mayikt.controller;

import com.mayikt.strategy.context.PayContextStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {
    @Autowired
    private PayContextStrategy payContextStrategy;

    @RequestMapping("/toPayHtml")
    public String toPayHtml(String payCode){

        return payContextStrategy.toPayHtml(payCode);
    }

    /**
     * 多重if判断，如果以后又出现一个新的支付，需代码中需多加一个if
     * 首先维护性差，违背开闭原则
     * @param payCode
     * @return
     */
    public String toPayHtml2(String payCode){
        if (payCode.equals("ali_pay")){
            return "调用支付宝接口...";
        }
        if (payCode.equals("xiaomi_pay")){
            return "调用小米支付接口...";
        }
        if (payCode.equals("yinlian_pay")){
            return "调用银联支付接口...";
        }
        if (payCode.equals("weixin_pay")){
            return "调用微信支付接口...";
        }
        return "未找到该接口";
    }
}
