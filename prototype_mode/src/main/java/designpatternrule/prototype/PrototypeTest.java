package designpatternrule.prototype;

import java.io.*;

public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        BaseInfo baseInfo = new BaseInfo("xxx");
        Product product = new Product("part1","part2","3","4",baseInfo);

        //原型模式，克隆机制,implements Cloneable接口
        Product clone = product.clone();
        System.out.println("original："+product);
        System.out.println("clone："+clone);

        System.out.println("--------------------------");
        product.getBaseInfo().setConpanyName("yyyy");
        System.out.println("original："+product);
        System.out.println("clone："+clone);



    }
}

class BaseInfo implements Cloneable,Serializable{
    private String conpanyName;

    public BaseInfo(String conpanyName){
        this.conpanyName=conpanyName;
    }

    public String getConpanyName() {
        return conpanyName;
    }

    public void setConpanyName(String conpanyName) {
        this.conpanyName = conpanyName;
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException{
        return (BaseInfo)super.clone();
    }

    @Override
    public String toString() {
        return super.hashCode()+" ] BaseInfo{" +
                "conpanyName='" + conpanyName + '\'' +
                '}';
    }
}

class Product implements Cloneable,Serializable{

    private final long serialVersionUID=42L;

    private String part1;
    private String part2;
    private String part3;
    private String part4;

    private BaseInfo baseInfo;
    //......

    public Product() {
    }

    public Product(String part1, String part2, String part3, String part4,BaseInfo baseInfo) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.baseInfo=baseInfo;
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

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    @Override
    protected Product clone() throws CloneNotSupportedException{
        //调用父类的克隆方法，实现实例的拷贝,V1
        Product product = (Product) super.clone();
        BaseInfo baseInfo = this.baseInfo.clone();
        product.setBaseInfo(baseInfo);

        //第二种方法：系列化反序列化，V2
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }


        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        Product  product= null;
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            product = (Product) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public String toString() {
        return super.hashCode()+" ] Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                ", baseInfo=" + baseInfo +
                '}';
    }
}
