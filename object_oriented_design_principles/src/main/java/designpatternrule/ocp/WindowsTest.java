package designpatternrule.ocp;

/**
 * 开闭原则（Open Closed Principle [ˈprɪnsəpl] ，OCP）
 */
public class WindowsTest {
    public static void main(String[] args) {
        AbstractSubject subject1 = new SpecificSubject1();
        subject1.display();
        AbstractSubject subject2 = new SpecificSubject2();
        subject2.display();
    }
}
