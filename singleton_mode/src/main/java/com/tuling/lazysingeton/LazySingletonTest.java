package com.tuling.lazysingeton;

public class LazySingletonTest {

    public static void main(String[] args) {
//        LazySingleton singleton01  = LazySingleton.getInstance();
//        LazySingleton singleton02 =LazySingleton.getInstance();
//        System.out.println(singleton01==singleton02);

        new Thread(()->{
            LazySingleton singleton = LazySingleton.getInstance();
            System.out.println(singleton);
        }).start();

        new Thread(()->{
            LazySingleton singleton = LazySingleton.getInstance();
            System.out.println(singleton);
        }).start();
    }
}
