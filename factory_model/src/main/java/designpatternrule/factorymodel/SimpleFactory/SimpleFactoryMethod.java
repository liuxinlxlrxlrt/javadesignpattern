package designpatternrule.factorymodel.SimpleFactory;

public class SimpleFactoryMethod {
    public static void main(String[] args) {
        designpatternrule.factorymodel.SimpleFactory.Application application = new designpatternrule.factorymodel.SimpleFactory.Application();
        designpatternrule.factorymodel.SimpleFactory.Product product = application.getObject("1");
        product.method1();
    }
}

interface Product{
    public void method1();
}
//稳定部分
class ProductA implements designpatternrule.factorymodel.SimpleFactory.Product {
    public void method1(){
        System.out.println("ProductA.method1 executed");
    }
}

class ProductB implements designpatternrule.factorymodel.SimpleFactory.Product {
    public void method1(){
        System.out.println("ProductB.method1 executed");
    }
}

//简单工厂模式，只是编程习惯，对实例化进行管理
class SimpleFactory{
    public static designpatternrule.factorymodel.SimpleFactory.Product createProduct(String type){
        if(type.equals("0")){
            return new designpatternrule.factorymodel.SimpleFactory.ProductA();
        }else if (type.equals("1")){
            return  new designpatternrule.factorymodel.SimpleFactory.ProductB();
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

        private designpatternrule.factorymodel.SimpleFactory.Product createProduct(String type){
        //......init
        //......

        return designpatternrule.factorymodel.SimpleFactory.SimpleFactory.createProduct(type);
    }

    designpatternrule.factorymodel.SimpleFactory.Product getObject(String type){

        designpatternrule.factorymodel.SimpleFactory.Product product= createProduct(type);
        //...
        return product;
    }
}
