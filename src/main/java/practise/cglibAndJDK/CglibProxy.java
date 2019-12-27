package practise.cglibAndJDK;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    //CGLib需要代理的对象
    private Object target;


    //重写拦截方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("敌军还有五秒到达战场，全军出击");
        Object invoke = method.invoke(target, objects);//方法执行，参数：target  参数数组：objects
        System.out.println("敌军到达战场，碾碎他们");
        return invoke;
    }

    //定义获取代理对象方法
    public Object getCglibProxy(Object objectTarget) {
        //为目标对象赋值
        this.target = objectTarget;
        Enhancer enhancer = new Enhancer();

        //设置父类，因为Cglib是针对指定的类生成一个子类，所以需要指定父类
        enhancer.setSuperclass(objectTarget.getClass());
        enhancer.setCallback(this);//设置回调
        Object result = enhancer.create();//创建并返回代理对象
        return result;
    }


}
