package designpatterns23.singleton.lazysingleton;

public class LazySingletonTest {
    public static void main(String[] args) {
        LazySingleton l1 = LazySingleton.getInstance();
        LazySingleton l2 = LazySingleton.getInstance();

        System.out.println(l1==l2);
    }
}
