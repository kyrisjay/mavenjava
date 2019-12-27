package practise.genericity.one;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Dao<User> dao=new Dao<>();

        dao.map=new HashMap<String, User>();
        dao.save("a",new User(1,"张三"));
        dao.save("b",new User(2,"李四"));
        dao.save("c",new User(3,"王五"));
        dao.save("d",new User(4,"赵四"));
        System.out.println(dao.map);

        System.out.println("--------------------------");

        System.out.println(dao.get("a"));
        System.out.println(dao.get("b"));
        System.out.println(dao.get("c"));
        System.out.println(dao.get("d"));

        System.out.println("--------------------------");

        dao.update("a",new User(5,"锐雯"));
        System.out.println(dao.map);

        System.out.println("--------------------------");

        System.out.println(dao.list());

        System.out.println("--------------------------");
        dao.delete("d");
        System.out.println(dao.map);
    }
}
