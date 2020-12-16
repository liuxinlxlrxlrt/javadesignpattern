package designpatterns23.singleton.hungrysingleton;

/**
 * 1、饿汉式（推荐）
 * 创建枚举默认就是线程安全的，所以不需要担心double checked locking，
 * 而且还能防止反序列化导致重新创建新的对象。
 * 保证只有一个实例（即使使用反射机制也无法多次实例化一个枚举量）。
 */
public enum HungrySingletonbyenum {

    /**
     *使用枚举方法的好处在于：
     * 1.枚举天生就是线程安全的，其在任意情况下都是单例
     * 2.枚举具有防止反射和发序列化的特点
     */
     SINGLE;

    private HungrySingletonbyenum() {
    }

    public void print() {
        System.out.println("hello world");
    }

}
