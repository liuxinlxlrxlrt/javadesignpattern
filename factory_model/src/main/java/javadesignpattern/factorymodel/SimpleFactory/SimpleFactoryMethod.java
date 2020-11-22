package javadesignpattern.factorymodel.SimpleFactory;

public class SimpleFactoryMethod {
    public static void main(String[] args) {
        javadesignpattern.factorymodel.SimpleFactory.Application application = new javadesignpattern.factorymodel.SimpleFactory.Application();
        javadesignpattern.factorymodel.SimpleFactory.Product product = application.getObject("1");
        product.method1();
    }
}

interface Product{
    public void method1();
}
//稳定部分
class ProductA implements javadesignpattern.factorymodel.SimpleFactory.Product {
    public void method1(){
        System.out.println("ProductA.method1 executed");
    }
}

class ProductB implements javadesignpattern.factorymodel.SimpleFactory.Product {
    public void method1(){
        System.out.println("ProductB.method1 executed");
    }
}

//简单工厂模式，只是编程习惯，对实例化进行管理
class SimpleFactory{
    public static javadesignpattern.factorymodel.SimpleFactory.Product createProduct(String type){
        if(type.equals("0")){
            return new javadesignpattern.factorymodel.SimpleFactory.ProductA();
        }else if (type.equals("1")){
            return  new javadesignpattern.factorymodel.SimpleFactory.ProductB();
        }else {
            return null;
        }
    }
}

class Application{
//    private ProductA createProduct(){
//        //......init
//        //......
//
//        return new ProductA();
//    }
//
//    ProductA getObject(){
//
//        ProductA product= createProduct();
//        //...
//        return product;
//    }

        private javadesignpattern.factorymodel.SimpleFactory.Product createProduct(String type){
        //......init
        //......

        return javadesignpattern.factorymodel.SimpleFactory.SimpleFactory.createProduct(type);
    }

    javadesignpattern.factorymodel.SimpleFactory.Product getObject(String type){

        javadesignpattern.factorymodel.SimpleFactory.Product product= createProduct(type);
        //...
        return product;
    }
}
