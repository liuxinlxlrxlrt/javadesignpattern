package com.tuling.hungrysingeton;

public class HungrySingleton {

    private static HungrySingleton singleton = new HungrySingleton();
    private  HungrySingleton(){

    }
    public static HungrySingleton getInstance(){
        return singleton;
    }
}
