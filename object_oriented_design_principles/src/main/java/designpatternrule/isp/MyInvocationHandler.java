package designpatternrule.isp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 1.InvocationHandler接口是proxy代理实例的调用处理程序实现的一个接口，
 * 每一个proxy代理实例都有一个关联的调用处理程序；
 * 在代理实例调用方法时，方法调用被编码分派到调用处理程序的invoke方法。
 */
public class MyInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * invoke方法是用于进行增强处理的
     * @param proxy 在内存中动态生成代理类的实例
     * @param method 当前目标对象正在执行的方法
     * @param args 当前目标对象正在执行的方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object invoke = method.invoke(target);
        return invoke;
    }
}
