package designpatterns23.singleton.lazysingletoninstance;


public class President {
    private static volatile President instance =null;

    private President(){
        System.out.println("产生一个总统！");
    }

    /**
     * 3、双重检查加锁（推荐）
     */
    public static President getInstance(){
        if(instance==null){
            synchronized (President.class){
                if (instance==null){
                    instance = new President();
                }
            }
        }else {
            System.out.println("已经有一个总统，不能产生新总统！");
        }
        return instance;
    }


    public void getName() {
        System.out.println("我是美国总统：特朗普。");
    }
}
