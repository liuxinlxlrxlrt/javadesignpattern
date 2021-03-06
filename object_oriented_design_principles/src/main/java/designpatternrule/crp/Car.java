package designpatternrule.crp;

public abstract class Car {

    abstract void move();

    Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
