package designpatterns23.prototype.instance02;

import javax.swing.*;

public class SunWukong extends JPanel implements Cloneable{
    private static final long serialVersionUID = 5543049531872119328L;
    public SunWukong() {
        JLabel l1 = new JLabel(new ImageIcon("src/Wukong.jpg"));
        this.add(l1);
    }
    public Object clone() {
        SunWukong w = null;
        try {
            w = (SunWukong) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝悟空失败!");
        }
        return w;
    }
}
