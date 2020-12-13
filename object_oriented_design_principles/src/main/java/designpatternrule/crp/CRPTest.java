package designpatternrule.crp;

public class CRPTest {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.setColor(new White());
        electricCar.getColor().colorKind();
        electricCar.move();
    }
}
