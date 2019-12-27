package example.reflectDemo;

/**
 * 静态代理
 */
public class DynProxy {
    public static void main(String[] args) {
        Person p = new PersonImpl();
        CarPerson carPerson = new CarPerson(p);
        carPerson.buyCar();
    }
}
