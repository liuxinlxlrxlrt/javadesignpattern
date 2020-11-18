package com.tuling.hungrysingeton;

public class HungrySingletonTest {
    public static void main(String[] args) {
            HungrySingleton singleton01 = HungrySingleton.getInstance();
            HungrySingleton singleton02=HungrySingleton.getInstance();
        System.out.println(singleton01==singleton02);
    }
}
