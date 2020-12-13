package designpatterns23.multiton.instance02;

import java.util.ArrayList;
import java.util.Random;

public class Emperor {
    //最多只能两个皇帝
    private static int maxNumOfEmperor =2;
    //装皇帝的名字
    private static ArrayList<String> emperorInfoList = new ArrayList<>(maxNumOfEmperor);
    //装皇帝的列表
    private static ArrayList<Emperor> emperorList =  new ArrayList<>(maxNumOfEmperor);
    //正在被人尊称的时哪个皇帝
    private static int countNumOfEmperor=0;

    //创建两个皇帝
    static {
        for (int i=0;i<maxNumOfEmperor;i++){
            emperorList.add(new Emperor("第"+(i+1)+"个皇帝"));
        }
    }

    private Emperor(){
        //不能再生产皇帝了
    }

    private Emperor(String info){
        emperorInfoList.add(info);
    }

    public static Emperor getInstance(){
        Random random = new Random();
        //随机创建一个皇帝
        countNumOfEmperor=random.nextInt(maxNumOfEmperor);
        return emperorList.get(countNumOfEmperor);
    }
    public static void emperorInfo(){
        System.out.println(emperorInfoList.get(countNumOfEmperor));
    }
}
