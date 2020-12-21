package com.mayikt.strategy.factory;

import com.mayikt.strategy.PayStrategy;
import com.mayikt.strategy.enumeration.PayEnumStrategy;

public class StrategyFactory {
    //使用策略工厂获取具体策略实现

    public static PayStrategy getPayStrategy(String strategyType){
        try {
            //获取具体的策略class地址
            /**
             * key：ALI_PAY，values：com.mayikt.strategy.impl.AliPayStrategy
             * PayEnumStrategy.valueOf(strategyType)获取枚举key：ALI_PAY
             * getClassName()获取枚举value：com.mayikt.strategy.impl.AliPayStrategy
             */
            String className = PayEnumStrategy.valueOf(strategyType).getClassName();
            System.out.println(className);
            return (PayStrategy)Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
