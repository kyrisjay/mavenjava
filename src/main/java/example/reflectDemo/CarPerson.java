package example.reflectDemo;

public class CarPerson implements Person {//代理类

    private  Person p;//目标类
    private  int money=50000;

    public CarPerson(Person p) {
        this.p=p;
    }

    @Override
    public void buyCar() {
        if (money>150000){
           p.buyCar();
        }
        System.out.println("钱少了。。。");
    }
}
