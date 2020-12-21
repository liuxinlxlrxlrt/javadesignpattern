package com.mayikt.strategy.enumeration;

public enum PayEnumStrategy {

    //支付宝支付
    //key：ALI_PAY，values：com.mayikt.strategy.impl.AliPayStrategy
    ALI_PAY("com.mayikt.strategy.impl.AliPayStrategy"),

    //微信支付
    WECHAT_PAY("com.mayikt.strategy.impl.WeChatPayStrategy");

    //class完整地址
    private String className;

    PayEnumStrategy(String className) {
        this.setClassName(className);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
