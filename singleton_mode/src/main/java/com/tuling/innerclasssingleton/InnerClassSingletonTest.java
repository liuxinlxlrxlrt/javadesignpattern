package com.tuling.innerclasssingleton;

public class InnerClassSingletonTest {
    public static void main(String[] args) {
        InnerClassSingleton singleton01 =  InnerClassSingleton.getInstance();
        InnerClassSingleton singleton02 = InnerClassSingleton.getInstance();
        System.out.println(singleton01==singleton02);
    }
}
