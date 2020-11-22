package com.tuling.enumeration;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum EnumSingleton {
    INSTANCE;

    public void print(){
        System.out.println(this.hashCode());
    }
}

class EnumTest{
    public static void main(String[] args) throws Exception {
//        Constructor<EnumSingleton> dc = EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
//        dc.setAccessible(true);
//        EnumSingleton enumSingleton = dc.newInstance("INSTANCE",0);

        EnumSingleton instance = EnumSingleton.INSTANCE;

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("EnumSingleton"));
        oos.writeObject(instance);
        oos.close();
    }
}
