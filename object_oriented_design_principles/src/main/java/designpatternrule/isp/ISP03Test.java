package designpatternrule.isp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 2.Proxy类就是用来创建一个代理对象的类，它提供了很多方法，但是我们最常用的是newProxyInstance方法。
 * 这个方法的作用就是创建一个代理类对象，它接收三个参数，我们来看下几个参数的含义
 */
public class ISP03Test {
    public static void main(String[] args) {
        //创建目标对象
        StuSroceList stuSroceList = new StuSroceList();
        //创建MyInvocationHandler实例
        InvocationHandler myInvocationHandler = new MyInvocationHandler(stuSroceList);
        //利用Proxy.newProxyInstance动态生成代理类以及代理对象
        /**
         * loader: 用哪个类加载器去加载代理对象
         * interfaces:动态代理类需要实现的接口
         * h:动态代理方法在执行时，会调用h里面的invoke方法去执行
         */
        InputModule inputModule = (InputModule)Proxy.newProxyInstance(stuSroceList.getClass().getClassLoader(),stuSroceList.getClass().getInterfaces(),myInvocationHandler);
        inputModule.insert();
    }
}
