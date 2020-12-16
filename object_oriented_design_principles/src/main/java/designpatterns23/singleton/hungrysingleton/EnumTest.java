package designpatterns23.singleton.hungrysingleton;

public class EnumTest {
    public static void main(String[] args) {
        //获取该实例只需要Singleton.INSTANCE，并且此种方式可以保证该单例线程安全、防反射攻击、防止序列化生成新的实例。
        HungrySingletonbyenum singletonbyenum1 = HungrySingletonbyenum.SINGLE;
        HungrySingletonbyenum singletonbyenum2= HungrySingletonbyenum.SINGLE;
        System.out.println(singletonbyenum1==singletonbyenum2);
        singletonbyenum1.print();
        singletonbyenum2.print();
    }
}
