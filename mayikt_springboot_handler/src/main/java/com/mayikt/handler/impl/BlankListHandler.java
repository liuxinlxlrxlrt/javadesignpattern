package com.mayikt.handler.impl;

import com.mayikt.handler.GatewayHandler;

public class BlankListHandler extends GatewayHandler {



    @Override
    public void service() {
        System.out.println("第二关>>黑名单拦截...");
        nextService();//执行下一关
    }

    //重构删除一下代码
//    /**
//     * 下一关用户会话
//     */
//    private ConversationHandler conversationHandler;
//
//    /**
//     *设置下一个GatewayHandler
//     */
//    public void setNextGatewayHandler(ConversationHandler conversationHandler){
//        this.conversationHandler=conversationHandler;
//    }
}
