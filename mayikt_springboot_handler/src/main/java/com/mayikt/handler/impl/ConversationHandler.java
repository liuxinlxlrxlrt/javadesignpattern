package com.mayikt.handler.impl;

import com.mayikt.handler.GatewayHandler;

public class ConversationHandler extends GatewayHandler {
    @Override
    public void service() {
        System.out.println("第三关>>用户会话...");
    }
}
