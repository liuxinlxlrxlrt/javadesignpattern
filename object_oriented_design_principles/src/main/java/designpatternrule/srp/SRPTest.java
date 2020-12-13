package designpatternrule.srp;

/**
 * 单一职责原则（Single Responsibility Principle，SRP
 */
public class SRPTest {
    public static void main(String[] args) {
        StudentWork studentWork = new StudentWork();
        studentWork.lifeGuidance(new Counselors());
        System.out.println("--------------------------------");
        studentWork.academicGuidance(new AcademicTutor());
    }
}
