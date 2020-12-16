package designpatterns23.singleton.staticinnerclasssingleton;

public class StaticTest {
    public static void main(String[] args) {
        StaticInnerClassSingleton singleton1 = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton singleton2 = StaticInnerClassSingleton.getInstance();
        System.out.println(singleton1==singleton2);
        singleton1.methodA();
        singleton2.methodA();
    }
}
