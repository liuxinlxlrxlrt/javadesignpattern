package designpatterns23.multiton.instance01;

public class DieClient {
    private static Die die1,die2;

    public static void main(String[] args) {
        die1= Die.getInstance(1);
        die2=Die.getInstance(2);
        System.out.println(die1.dice());
        System.out.println(die2.dice());
    }
}
