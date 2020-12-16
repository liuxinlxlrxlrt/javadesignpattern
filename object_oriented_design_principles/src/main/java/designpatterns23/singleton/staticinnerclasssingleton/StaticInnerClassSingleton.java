package designpatterns23.singleton.staticinnerclasssingleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 静态内部类方式（推荐）
 * 加载一个类时，其内部类不会同时被加载。一个类被加载，当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生。
 * 由于在调用 StaticSingleton.getInstance() 的时候，才会对单例进行初始化，而且通过反射，是不能从外部类获取内部类的属性的；
 * 由于静态内部类的特性，只有在其被第一次引用的时候才会被加载，所以可以保证其线程安全性。
 * 总结：
 * 优势：兼顾了懒汉模式的内存优化（使用时才初始化）以及饿汉模式的安全性（不会被反射入侵）。
 * 劣势：需要两个类去做到这一点，虽然不会创建静态内部类的对象，但是其 Class 对象还是会被创建，而且是属于永久带的对象。
 */
public class StaticInnerClassSingleton implements Serializable {

    private static final long serialVersionUID = 3L;
    /**
     * 一个私有的静态内部类，用于初始化一个静态final实例
     */
    private static class StaticInnerClasssSingletonHolder{
        private static final StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
    }
    /**
     * 私有构造方法，禁止在其他类中创建实例
     */
    private StaticInnerClassSingleton() {
        //构造器判断，防止反射攻击，大家可以在下面这行if判断打断点来测试一下这个方法的过程，很好理解的
        if(StaticInnerClasssSingletonHolder.singleton != null){
            throw new IllegalStateException();//防止反射破坏单例模式
        }

    }
    /**
     * 获取实例
     */
    public static StaticInnerClassSingleton getInstance(){
        return StaticInnerClasssSingletonHolder.singleton;
    }

    //防止反序列化破坏单例模式
    private Object readResolve() throws ObjectStreamException {
        return StaticInnerClasssSingletonHolder.singleton;
    }

    public void methodA(){
        System.out.println("methodA");
    }

    public void methodB(){
        System.out.println("methodB");
    }
}
