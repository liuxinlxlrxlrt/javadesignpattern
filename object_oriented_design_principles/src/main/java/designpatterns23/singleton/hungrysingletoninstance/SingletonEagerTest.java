package designpatterns23.singleton.hungrysingletoninstance;

import javax.swing.*;
import java.awt.*;

public class SingletonEagerTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame("饿汉单例模式测试");
        jf.setLayout(new GridLayout(1, 2));
        Container contentPane = jf.getContentPane();
        Bajie bajie1 = Bajie.getInstance();
        contentPane.add(bajie1);
        Bajie bajie2= Bajie.getInstance();
        contentPane.add(bajie2);
        if (bajie1 == bajie2) {
            System.out.println("他们是同一人！");
        } else {
            System.out.println("他们不是同一人！");
        }
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
