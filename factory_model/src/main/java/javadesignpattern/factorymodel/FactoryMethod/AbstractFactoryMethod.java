package javadesignpattern.factorymodel.FactoryMethod;

public class AbstractFactoryMethod {
    public static void main(String[] args) {
//        Application application = new ConcreateProdectA();
        Application application = new ConcreateProdectB();
        Product product = application.createProduct();
        product.method1();
    }
}

interface Product{
    public void method1();
}

//稳定部分
class ProductA implements Product{
    public void method1(){
        System.out.println("ProductA.method1 executed");
    }
}

class ProductB implements Product{
    public void method1(){
        System.out.println("ProductB.method1 executed");
    }
}

abstract class Application{
    //工厂方法
    abstract Product createProduct();
}

class ConcreateProdectA extends Application{
    @Override
    Product createProduct(){
        //......
        return new ProductA();
    }
}

class ConcreateProdectB extends Application{
    @Override
    Product createProduct(){
        //......
        return new ProductB();
    }
}
