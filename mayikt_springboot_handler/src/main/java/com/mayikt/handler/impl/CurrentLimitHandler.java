package com.mayikt.handler.impl;

import com.mayikt.handler.GatewayHandler;

public class CurrentLimitHandler extends GatewayHandler {


    @Override
    public void service() {
        System.out.println("第一关>>API接口的限流...");
        nextService();//执行下一关
    }


     //重构后删除一下代码
//    /**
//     * 下一个黑名单拦截
//     */
//    private BlankListHandler blankListHandler;
//    /**
//     * 设置下一个GatewayHandler
//     */
//    public void setNextGatewayHandler(BlankListHandler blankListHandler){
//        this.blankListHandler=blankListHandler;
//    }
}
