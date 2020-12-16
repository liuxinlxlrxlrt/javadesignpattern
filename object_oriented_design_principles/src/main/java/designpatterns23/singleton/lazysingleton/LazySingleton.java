package designpatterns23.singleton.lazysingleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 3.双重校验锁法
 * 解释一下在并发时，双重校验锁法会有怎样的情景：
 *
 * STEP 1. 线程A访问getInstance()方法，因为单例还没有实例化，所以进入了锁定块。
 *
 * STEP 2. 线程B访问getInstance()方法，因为单例还没有实例化，得以访问接下来代码块，而接下来代码块已经被线程1锁定。
 *
 * STEP 3. 线程A进入下一判断，因为单例还没有实例化，所以进行单例实例化，成功实例化后退出代码块，解除锁定。
 *
 * STEP 4. 线程B进入接下来代码块，锁定线程，进入下一判断，因为已经实例化，退出代码块，解除锁定。
 *
 * STEP 5. 线程A初始化并获取到了单例实例并返回，线程B获取了在线程A中初始化的单例。
 *
 * 理论上双重校验锁法是线程安全的，并且，这种方法实现了lazyloading。
 *
 * Volatile关键字的作用: 禁止进行指令的重排序
 * @return
 */
public class LazySingleton implements Serializable {

    private static final long serialVersionUID = 1L;

    //保证 instance(实例) 在所有线程中同步,防止重排序
    private static volatile LazySingleton instance=null;

    //私有化构造器:private 避免类在外部被实例化
    //在私有构造器里判断intance，如存在则抛异常(防止反射侵犯私有构造器),
    // 防止反射获取多个对象的漏洞
    private LazySingleton(){
        if(instance!=null) {//防止反射破解
            throw new RuntimeException();
        }
    }

    /**
     * 1、适用于单线程环境（不推荐）
     * 此方式在单线程的时候工作正常，但在多线程的情况下就有问题了。
     * 如果两个线程同时运行到判断instance是否为null的if语句，并且instance的确没有被创建时，
     * 那么两个线程都会创建一个实例，此时类型Singleton1就不再满足单例模式的要求了。
     *
     * 2.这种懒汉式有什么缺点呢？
     * 首先就是线程不安全，如果在多线程的情况下，首先线程一完成判断，但是还没有实例化对象时，
     * 线程二进入判断，此时线程一完成实例化，而线程二也会再次实例化，从而破坏单例。
     *
     * 懒汉式的问题：并发访问时，T1执行到A处暂停，T2同样执行到A处，并继续往下执行，
     * T2实例化了instance，T2执行完，T1线程继续执行，此时T1线程会继续执行instance = new Singleton2();
     * 无法保证单例
     *
     * 3.解决方法是：加锁
     */
    public static LazySingleton getInstanceA() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 1、适用于多线程环境，但效率不高（不推荐）
     * 为了保证在多线程环境下我们还是只能得到该类的一个实例，只需要在getInstanceB()方法加上同步关键字sychronized，
     * 就可以了。但每次调用getInstanceB()方法时都被synchronized关键字锁住了，会引起线程阻塞，影响程序的性能。
     *
     * 2.这个单例又有什么缺点呢？
     * 如果锁的是静态方法，那么相当于锁的整个类，比较消耗内存资源。因此引入双重检查机制。
     *
     */
    public static synchronized LazySingleton getInstanceB() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 1、双重检查加锁（推荐）
     * 为了在多线程环境下，不影响程序的性能，不让线程每次调用getInstanceC()方法时都加锁，
     * 而只是在实例未被创建时再加锁，在加锁处理里面还需要判断一次实例是否已存在。
     *
     * 2.这个单例的优点就是锁的范围小了。降低了内存开销。
     * 那么它真的完美了吗？其实还是有点小小隐患，那就是在实例化对象的时候发生重排序
     * （在java的语言规范中是允许单线程进行重排序的，增加效率，但是在多线程中就会存在隐患），
     * 这时就需要引入我们的volatile关键字，来避免重排序。
     *
     * 使用了双重检查和volatile关键字之后，在性能和线程安全方面都得到了满足~~
     *
     * 饿汉式
     */
    public static LazySingleton getInstance(){
        if (instance == null){
            synchronized (LazySingleton.class){
                if(instance==null){
                    instance=new LazySingleton();
                }
            }
        }
        return instance;
    }

    //序列化单例，重写readResolve()方法
    // 防止反序列化获取多个对象的漏洞。
    // 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，readResolve()方法都会被调用到。
    // 实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象。
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}
