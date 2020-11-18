package com.tuling.innerclasssingleton;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InnerClassSingleton {
    //静态内部类，何时加载，调用getInstance()进行返回的时候才会初始化
    private static class InnerClassHolder{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton(){}

    public static InnerClassSingleton getInstance(){
        return InnerClassHolder.instance;
    }

}
