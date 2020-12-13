package designpatternrule.lsp.correct;

public class Animal {
    double runSpeed;

    public void setRunSpeed(double speed){
            this.runSpeed=speed;
    }

    public double getRuntime(double distance){
        return (distance/runSpeed) ;
    }
}
