package practise.cglibAndJDK;

public class Test {
    public static void main(String[] args) {
        System.out.println("-----------cglib------------");
        CglibProxy cp=new CglibProxy();//实例化CglibProxy对象
        shop sh=(shop)cp.getCglibProxy(new LOL());//获取代理对象
        sh.buy("药");


        System.out.println("-----------JDK------------");
        JDKProxy jp=new JDKProxy();
        shop sp=(shop)jp.newProxy(new LOL());
        sp.sell("大剑","1300");
    }
}
