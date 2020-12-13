package designpatterns23.multiton.instance01;

import java.util.Date;
import java.util.Random;

/**
 * 比如每一麻将局都有两个骰子，因此骰子就应当是双态类，这里就以这个系统为例，说明多例模式的结构。
 */
public class Die {
    private static Die die1= new Die();
    private static Die die2= new Die();

    /**
     *私有的构造函数保证外界无法直接将此类实例化
     */
    private Die(){

    }

    /**
     *工厂方法
     */
    public static Die getInstance(int whichOne){
//        if (whichOne==1){
//            return die1;
//        }else {
//            return die2;
//        }
        switch (whichOne){
            case 1:
                return die1;
            case 2:
                return die2;
            default:
                return null;
        }
    }

    /**
     *投骰子，返回一个在1－6之间的随机书
     */
    public synchronized int dice(){
        Date date = new Date();
        Random random = new Random(date.getTime());
        int value = random.nextInt();//获取随机数
        value = Math.abs(value);//获取随机数的绝对值
        value=value%6;//对6取模
        value+=1;//由于 value的范围是0－5，所以value+1成为1-6
        return value;
    }
}
