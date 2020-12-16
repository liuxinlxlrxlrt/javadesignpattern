package designpatterns23.singleton.lazysingletoninstance;

public class SingletonLazyTest {
    public static void main(String[] args) {
        President president1= President.getInstance();
        president1.getName();
        President president2= President.getInstance();
        president2.getName();

        if (president1 == president2) {
            System.out.println("他们是同一人！");
        } else {
            System.out.println("他们不是同一人！");
        }
    }
}
