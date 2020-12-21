package com.mayikt.mapper;

import com.mayikt.entity.PaymentChannelEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

public interface PaymentChannelMapper {

    @Select("SELECT id as id,CHANNEL_NAME as CHANNELNAME,CHANNEL_ID as CHANNELID," +
            "strategy_bean_id as strategybeanid FROM payment_channel " +
            "where CHANNEL_ID =#{payCode}")
    PaymentChannelEntity getPaymentChannel(String payCode);
}
