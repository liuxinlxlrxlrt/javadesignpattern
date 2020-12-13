package designpatternrule.lsp.correct;

public class Bird extends Animal{
    double flySpeed;

    public void setFlySpeed(double speed){
        this.flySpeed=speed;
    }

    public double getFlyTime(double distance){
        return (distance/flySpeed);
    }
}
