package designpatternrule.isp;


import java.lang.reflect.Method;

public class ISPTest {
    public static void main(String[] args) throws Exception {
        //获取字节码文件对象,第一种方式
        Class sroceListClass1 =StuSroceList.class;
        System.out.println(sroceListClass1);
        //结果：class javadesignpattern.isp.StuSroceList

        //获取字节码文件对象,第二种方式
        StuSroceList inputModule = new StuSroceList();
        Class sroceListClass2 = inputModule.getClass();
        System.out.println(sroceListClass2);
        //结果：class javadesignpattern.isp.StuSroceList

        //获取字节码文件对象,第三种方式
        String className="javadesignpattern.isp.StuSroceList";
        Class sroceListClass3 = Class.forName(className);
        System.out.println(sroceListClass3);
        //结果：class javadesignpattern.isp.StuSroceList

        //获取其实例对象
        StuSroceList stuSroceList = (StuSroceList) sroceListClass1.newInstance();
        System.out.println("实例对象："+stuSroceList);
        //结果：实例对象：javadesignpattern.isp.StuSroceList@1b6d3586

        //获取所有方法
        try {
            Method[] methods = stuSroceList.getClass().getMethods();
            for (Method method : methods) {
                System.out.println(method);
                //执行实例对象方法
                //通过发射的机制，可以通过invoke方法来调用类的函数。
                // invoke函数的第一个参数是调用该方法的实例，如果该方法是静态方法，那么可以用null或者用类来代替，
                // 第二个参数是变长的，是调用该方法的参数。
                method.invoke(stuSroceList);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }
}
