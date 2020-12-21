package com.mayikt.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements ApplicationContextAware {

    /**
     * ApplicationContextAware 通过它Spring容器会自动把上下文环境对象调用
     * ApplicationContextAware接口中的setApplicationContext方法。
     * 实现了这个ApplicationContextAware接口的bean，当spring容器初始化的时候，
     * 会自动的将ApplicationContext注入进来：
     */

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取Bean
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean
    public static <T> T getBean(Class<T> tClazz){
        return getApplicationContext().getBean(tClazz);
    }

    //通过name以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> tClazz){
        return getApplicationContext().getBean(name,tClazz);
    }
}
