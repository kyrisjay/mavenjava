package example.reflectDemo3;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Lawsuit lawsuit = new PersonAImplLawsuit();//李四打官司
        DynamicProxy dynamicProxy = new DynamicProxy(lawsuit);

        Lawsuit ob = (Lawsuit) Proxy.newProxyInstance(lawsuit.getClass().getClassLoader(), lawsuit.getClass().getInterfaces(), dynamicProxy);
        ob.submit("无良老板跑路");
        ob.defend();
    }
}
