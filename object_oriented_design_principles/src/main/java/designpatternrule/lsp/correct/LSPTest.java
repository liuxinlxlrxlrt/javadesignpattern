package designpatternrule.lsp.correct;

/**
 * 里氏替换原则（Liskov Substitution Principle，LSP）
 */
public class LSPTest {
    public static void main(String[] args) {
        Animal animal = new BrownKiwi();
        Bird bird = new Swallow();

        animal.setRunSpeed(60);
        bird.setFlySpeed(120);
        System.out.println("如果飞行300公里");

        try {
            System.out.println("燕子飞行时间为："+bird.getFlyTime(300)+"小时");
            System.out.println("几维鸟奔跑时间为："+animal.getRuntime(300)+"小时");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
