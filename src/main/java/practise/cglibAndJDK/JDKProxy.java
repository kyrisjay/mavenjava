package practise.cglibAndJDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

   //代理的目标对象
    private Object object;

    //将目标对象传入进行代理
    public Object newProxy(Object object){
        this.object=object;//为目标对象object赋值

        //JDK动态代理只能针对实现了接口的类进行代理，newProxyInstance 函数所需参数就可看出
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("敌军还有五秒到达战场，全军出击");
        Object result = method.invoke(object,args);
        System.out.println("敌军到达战场，碾碎他们");
        return result;
    }
}
