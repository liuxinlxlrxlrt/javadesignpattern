package com.tuling.lazysingeton;

public class LazySingleton {
    //防止重排序
    private volatile static LazySingleton instance;

    private LazySingleton(){

    }

    //public synchronized static LazySingleton getInstance(){}
    //方法加锁，性能较低
    //
    public static LazySingleton getInstance(){
        if(instance==null){
            synchronized (LazySingleton.class){
                if(instance==null){
                    instance= new LazySingleton();
                    //在字节码的层面
                    /**
                     * JIT CPU 计时重排
                     * 1.分配空间
                     * 2.初始化
                     * 3.引用赋值
                     */
                }
            }
        }
        return instance;
    }
}
