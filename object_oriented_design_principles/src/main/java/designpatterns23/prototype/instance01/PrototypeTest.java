package designpatterns23.prototype.instance01;

public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype realizetype= new Realizetype();
        Realizetype realizetype2 = (Realizetype) realizetype.clone();
        System.out.println(realizetype==realizetype2);
    }
}
