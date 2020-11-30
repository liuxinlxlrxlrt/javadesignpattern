package javadesignpattern.lsp.error;

/**
 * 里氏替换原则（Liskov Substitution Principle，LSP）
 */
public class Bird {

    double flySpeed;

    public void setSpeed(double speed) {
        this.flySpeed = speed;
    }

    public double getFlyTime(double distance){
        return (distance/flySpeed);
    }
}
