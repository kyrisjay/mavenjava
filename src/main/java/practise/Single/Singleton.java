package practise.Single;

/**
 * 饿汉模式
 * 饿汉式是在类加载的时候创建实例,所以线程是安全的
 */
public class Singleton {
    private static final Singleton sl=new Singleton();
    private Singleton(){

    }

    public static Singleton getInstance(){
        return sl;
    }
}
