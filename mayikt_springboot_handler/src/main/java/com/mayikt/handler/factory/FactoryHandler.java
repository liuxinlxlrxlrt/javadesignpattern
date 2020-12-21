package com.mayikt.handler.factory;

import com.mayikt.handler.impl.BlankListHandler;
import com.mayikt.handler.impl.ConversationHandler;
import com.mayikt.handler.impl.CurrentLimitHandler;

/**
 * 工厂
 */
public class FactoryHandler {

    public static CurrentLimitHandler getFirstGatewayHandler(){
        //第一关
        CurrentLimitHandler currentLimitHandler = new CurrentLimitHandler();
        //第二关
        BlankListHandler blankListHandler = new BlankListHandler();
        currentLimitHandler.setNextGatewayHandler(blankListHandler);
        //第三关
        ConversationHandler conversationHandler = new ConversationHandler();
        blankListHandler.setNextGatewayHandler(conversationHandler);

        return currentLimitHandler;
    }
}
