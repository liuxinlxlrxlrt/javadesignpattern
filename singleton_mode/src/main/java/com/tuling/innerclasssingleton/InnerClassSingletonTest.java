package com.tuling.innerclasssingleton;

import java.lang.reflect.Constructor;

public class InnerClassSingletonTest {
    public static void main(String[] args) throws Exception{
//        InnerClassSingleton singleton01 =  InnerClassSingleton.getInstance();
//        InnerClassSingleton singleton02 = InnerClassSingleton.getInstance();
//        System.out.println(singleton01==singleton02);

//        new Thread(() ->{
//            InnerClassSingleton singleton =  InnerClassSingleton.getInstance();
//            System.out.println(singleton);
//        }).start();
//
//        new Thread(()->{
//            InnerClassSingleton singleton =  InnerClassSingleton.getInstance();
//            System.out.println(singleton);
//        }).start();

        Constructor<InnerClassSingleton> singletonConstructor = InnerClassSingleton.class.getDeclaredConstructor();

        singletonConstructor.setAccessible(true);
        InnerClassSingleton singleton = singletonConstructor.newInstance();
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        System.out.println(singleton==instance);
    }
}
