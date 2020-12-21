package com.mayikt.handler.controller;

import com.mayikt.handler.factory.FactoryHandler;
import com.mayikt.handler.impl.CurrentLimitHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandlerController {

    @RequestMapping("/clientHandler")
    public String clientHandler(){
        CurrentLimitHandler firstGatewayHandler = FactoryHandler.getFirstGatewayHandler();
        firstGatewayHandler.service();
        return "success";
    }
}
