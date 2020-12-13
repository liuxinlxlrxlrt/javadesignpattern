package designpatternrule.dip;

/**
 * 依赖倒置原则（Dependence Inversion Principle，DIP）
 */
public class DIPTest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        System.out.println("顾客购买以下商品：");
        customer.shopping(new ShaoguanShop());
        customer.shopping(new WuyuanShop());
    }
}
