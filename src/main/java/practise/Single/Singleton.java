package practise.Single;

public class Singleton {
    //双重检查锁  volatile 关键字可以让所有线程都能看到共享内存的最新状态
    private static volatile Singleton instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

}
