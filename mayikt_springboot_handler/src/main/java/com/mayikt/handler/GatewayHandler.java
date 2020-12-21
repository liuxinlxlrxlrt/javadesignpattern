package com.mayikt.handler;

public abstract class GatewayHandler {

    /**
     * 下一个handler
     */
    public GatewayHandler nextGatewayHandler;

    /**
     * 使用抽象类定义共同方法的行为
     */
    public abstract void service();

    /**
     * 执行下一个hanndler
     */
    protected void nextService(){
        if(nextGatewayHandler!=null){
            nextGatewayHandler.service();
        }
    }

    /**
     *设置下一个GatewayHandler
     */
    public void setNextGatewayHandler(GatewayHandler nextGatewayHandler){
        this.nextGatewayHandler=nextGatewayHandler;
    }
}
