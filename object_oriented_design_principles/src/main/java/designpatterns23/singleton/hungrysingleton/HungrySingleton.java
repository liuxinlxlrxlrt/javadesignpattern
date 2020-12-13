package designpatterns23.singleton.hungrysingleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 1、饿汉式（推荐）
 * 饿汉式单例类:在类初始化时，已经自行实例化。
 *
 * 2.饿汉式有什么优点呢？
 * 那就是在类加载的时候就已经初始化了，避免了线程同步的问题，
 * 当然缺点也就是没了延迟加载的特性，如果没有使用过，就会造成资源的浪费。
 *
 * 3.什么是序列化和反序列化
 * 序列化 (Serialization)是将对象的状态信息转换为可以存储或传输的形式的过程。
 * 在序列化期间，对象将其当前状态写入到临时或持久性存储区。
 * 以后，可以通过从存储区中读取或反序列化对象的状态，重新创建该对象。
 *
 * 看重点： 以后，可以通过从存储区中读取或反序列化对象的状态，重新创建该对象。
 * 也就是说如果你的单例实现了Serializable，反序列化出来的对象，是重新创建的对象了。
 */
public class HungrySingleton implements Serializable {

    private static final long serialVersionUID = 2L;

    //该模式的特点是类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了。
    //final声明的变量必须在类加载完成的时候就赋值
    private static final HungrySingleton instance = new HungrySingleton();

    //空参构造方法:private 避免类在外部被实例化

    /**
     * 1.如何防止反射机制和序列化反序列化破坏单例模式
     * 解决方式，暴力解决，在构造方法中判断实例是否为null，如果不为null，直接抛异常。
     */
    private HungrySingleton() {
        if (instance!=null){       //防止反射破坏单例
            throw new RuntimeException("单例构造器进制反射调用\"");
        }
    }

    public static HungrySingleton getInstance(){
        return instance;
    }

    //解决方法，单例类中增加readResolve()方法，可以避免实例重复。
    /**
     * 原因： 可以通过查看readObject()源码，看看是如何反序列化创建对象的，
     * 这个方法创建完对象之后会通过反射机制判断类中是否有readResolve()方法，
     * 如果有readResolve()方法，会通过反射机制调用这个方法。所以当你在单例类中写上readResolve()方法，
     * 是能够保证得到的同一个单例的，能够保证单例的全局唯一性。
     * 补充： 但是避免不了序列化重复创建对象，实际上我们这种写法只是将反序列化创建的对象覆盖掉了，在执行过程中JVM还是创建了新的对象。
     */
    private Object readResolve() throws ObjectStreamException {
        //防止反序列化破坏单例
        return instance;
    }

}
