package com.mayikt.strategy.context;

import com.mayikt.entity.PaymentChannelEntity;
import com.mayikt.mapper.PaymentChannelMapper;
import com.mayikt.strategy.factory.StrategyFactory;
import com.mayikt.strategy.PayStrategy;
import com.mayikt.utils.SpringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayContextStrategy {
    /**
     * 第二种方式：数数据库获取
     */
    @Autowired
    private PaymentChannelMapper paymentChannelMapper;

    public String toPayHtml(String payCode){
        if (StringUtils.isEmpty(payCode)){
            return "payCode为空!...";
        }
        //查询数据可以获取策略的具体实现
        PaymentChannelEntity paymentChannel = paymentChannelMapper.getPaymentChannel(payCode);
        System.out.println("paymentChannel："+paymentChannel);
        if (paymentChannel==null){
            return "没有查询到支付渠道";
        }
        //获取spring注入的bean的id
        String strategyBeanId = paymentChannel.getStrategyBeanId();
        System.out.println("strategyBeanId："+strategyBeanId);
        if(StringUtils.isEmpty(strategyBeanId)){
            return "数据库中没有配置strategyBeanId";
        }

        PayStrategy payStrategy = SpringUtils.getBean(strategyBeanId, PayStrategy.class);
        System.out.println("payStrategy："+payStrategy);

        return payStrategy.toPayHtml();
    }


//    /**
//     * 第一种方法：获取具体策略通过工厂方法
//     * @param payCode
//     * @return
//     */
//    public String toPayHtml(String payCode){
//      if (StringUtils.isEmpty(payCode)){
//          return "payCode不能为空！。。。";
//      }
//      //1.使用策略工厂获取具体策略实现
//        PayStrategy payStrategy = StrategyFactory.getPayStrategy(payCode);
//        if (payStrategy==null){
//            return "没哟找到具体策略的实现";
//        }
//        return payStrategy.toPayHtml();
//    }
}
