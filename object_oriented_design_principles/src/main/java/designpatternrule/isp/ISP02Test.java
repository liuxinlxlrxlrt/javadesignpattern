package designpatternrule.isp;

public class ISP02Test {
    public static void main(String[] args) {
        InputModule inputModule = StuSroceList02.getInputModule();
        CountModule countModule = StuSroceList02.getCountModule();
        PrintModule printModule = StuSroceList02.getPrintModule();
        inputModule.insert();
        countModule.countTotalScore();
        printModule.printStuInfo();
    }
}
