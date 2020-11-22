package com.tuling.innerclasssingleton;


import java.io.ObjectStreamException;
import java.io.Serializable;

public class InnerClassSingleton implements Serializable {

    static final long serialVersionUID = 42L;

    //静态内部类，何时加载，调用getInstance()进行返回的时候才会初始化
    private static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
        //防止使用反射进行多例的实例化
        if (InnerClassHolder.instance != null) {
            throw new RuntimeException("单例不允许多个实例");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }

    Object readResolve() throws ObjectStreamException {
        return InnerClassHolder.instance;
    }

    float ss = 0.0f;
}
