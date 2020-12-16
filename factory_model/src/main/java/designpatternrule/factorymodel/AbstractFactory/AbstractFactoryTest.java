package designpatternrule.factorymodel.AbstractFactory;
//场景：针对数据库开发一个基础的组件
public class AbstractFactoryTest {
    public static void main(String[] args) {

//        IDatabaseUtils iDatabaseUtils= new MysqlDatabaseUtils();
        IDatabaseUtils iDatabaseUtils = new OracleDatabaseUtils();
        IConnection connection = iDatabaseUtils.getConnection();
        connection.connect();
        ICommand command = iDatabaseUtils.getCommand();
        command.command();

    }
}

//变化：mysql,oracle
//共性：connection,command

interface IConnection{
    void connect();
}

class MysqlConnecttion implements IConnection{

    @Override
    public void connect() {
        System.out.println("mysql connect......");
    }
}

class OracleConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("oracle connection .......");
    }
}

interface ICommand{
    void command();
}

class MysqlCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("mysql command......");
    }
}

class OracleCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("oracle command......");
    }
}

//抽象工厂模式
interface IDatabaseUtils{
    IConnection getConnection();
    ICommand getCommand();
}

class MysqlDatabaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new MysqlConnecttion();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}

class OracleDatabaseUtils implements IDatabaseUtils{


    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}



