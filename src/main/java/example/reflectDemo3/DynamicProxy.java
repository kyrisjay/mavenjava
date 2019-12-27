package example.reflectDemo3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    //jdk 动态代理 接口 目标类   一个代理接口代理 Proxy类

    private Object object;//目标类  代理类可以代理所有对象

    public DynamicProxy( Object lawsuit) {
        this.object = lawsuit;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //System.out.println("执行的方法名称："+method.getName());
        //System.out.println("传递过来的参数："+args[0]);
        //执行代理目标的方法
        //执行目标方法之前 数据检索
//        for(Object obj:args){
//            System.out.println(obj);
//        }

        File file=new File("xs.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file,true));
        for(int i=0;i<args.length;i++){
            if(args[i]!=null){
                bufferedWriter.write(args[i]+",");
                bufferedWriter.flush();
            }
        }
        System.out.println("证据已经保存");
       Object obj= method.invoke(object,args);
        return obj;
    }

 }
