package javadesignpattern.bulider;

public class BuilderTest {
    public static void main(String[] args) {
//        Product product = new Product();
//        product.setCompanyName("xxx");
//        product.setPart1("XXX");
//        //......

        //场景一：构造顺序是有依赖关系

//        DefaultConcreateProductBuilder defaultConcreateProductBuilder = new DefaultConcreateProductBuilder();
//        Director director = new Director(defaultConcreateProductBuilder);
        SpecialConcreateProductBuilder specialConcreateProductBuilder = new SpecialConcreateProductBuilder();
        Director director = new Director(specialConcreateProductBuilder);
        Product product = director.makeProduct("productName123", "cn..123.", "part1", "part2", "part3", "part4");
        System.out.println(product);

    }
}

interface ProductBuilder{
    void builderProductName(String productName);
    void builderCompanyName(String companyName);
    void builderPart1(String part1);
    void builderPart2(String part2);
    void builderPart3(String part3);
    void builderPart4(String part4);

    Product build();
}

class DefaultConcreateProductBuilder implements ProductBuilder{

    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    @Override
    public void builderProductName(String productName) {
        this.productName=productName;
    }

    @Override
    public void builderCompanyName(String companyName) {
        this.companyName=companyName;
    }

    @Override
    public void builderPart1(String part1) {
        this.part1=part1;
    }

    @Override
    public void builderPart2(String part2) {
        this.part2=part2;
    }

    @Override
    public void builderPart3(String part3) {
        this.part3=part3;
    }

    @Override
    public void builderPart4(String part4) {
        this.part4=part4;
    }

    @Override
    public Product build() {
        return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3,this.part4);
    }
}

class SpecialConcreateProductBuilder implements ProductBuilder{

    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    @Override
    public void builderProductName(String productName) {
        this.productName=productName;
    }

    @Override
    public void builderCompanyName(String companyName) {
        this.companyName=companyName;
    }

    @Override
    public void builderPart1(String part1) {
        this.part1=part1;
    }

    @Override
    public void builderPart2(String part2) {
        this.part2=part2;
    }

    @Override
    public void builderPart3(String part3) {
        this.part3=part3;
    }

    @Override
    public void builderPart4(String part4) {
        this.part4=part4;
    }

    @Override
    public Product build() {
        return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3,this.part4);
    }
}

class Director{

    private ProductBuilder builder;

    public Director(ProductBuilder builder) {
        this.builder = builder;
    }

    public Product makeProduct(String productName, String companyName, String part1, String part2, String part3, String part4){
        builder.builderProductName(productName);
        builder.builderCompanyName(companyName);
        builder.builderPart1(part1);
        builder.builderPart2(part2);
        builder.builderPart3(part3);
        builder.builderPart4(part4);

        Product product =builder.build();
        return product;
    }
}

class Product {

    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    //......
    public Product(){

    }

    public Product(String productName, String companyName, String part1, String part2, String part3, String part4) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public String getPart4() {
        return part4;
    }

    public void setPart4(String part4) {
        this.part4 = part4;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                '}';
    }
}
