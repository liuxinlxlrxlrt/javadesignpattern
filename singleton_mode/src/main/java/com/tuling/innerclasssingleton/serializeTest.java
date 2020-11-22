package com.tuling.innerclasssingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class serializeTest {

    public static void main(String[] args) throws Exception {
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        //序列化生成序列化文件
//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("testSerializable"));
//        outputStream.writeObject(instance);
//        outputStream.close();

        //反序列化创建对象，不会调构造函数进行初始化，
        /**
         * 1.添加序列号
         * 2.添加如下代码
         * Object readResolve() throws ObjectStreamException{
         *         return InnerClassHolder.instance;
         *     }
         */

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("testSerializable"));
        InnerClassSingleton object = (InnerClassSingleton) ois.readObject();
        System.out.println(instance == object);//false
    }
}
