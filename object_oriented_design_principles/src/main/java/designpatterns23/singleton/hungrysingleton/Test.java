package designpatterns23.singleton.hungrysingleton;

public class Test {
    public static void main(String[] args) {
        HungrySingleton h1= HungrySingleton.getInstance();
        HungrySingleton h2 = HungrySingleton.getInstance();
        System.out.println(h1==h2);
    }
}
