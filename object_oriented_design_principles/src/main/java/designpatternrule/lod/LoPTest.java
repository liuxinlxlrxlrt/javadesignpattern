package designpatternrule.lod;

/**
 *迪米特法则（Law of Demeter，LoD）
 */
public class LoPTest {
    public static void main(String[] args) {

        Agent agent = new Agent();
        agent.setMyStar(new Star("任贤齐"));
        agent.setMyFans(new Fans("小明"));
        agent.setMyCompany(new Company("小米公司"));
        agent.meeting();
        agent.business();

    }
}
