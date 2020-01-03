package practise.Single;

/**
 * 懒汉模式
 */
public class LazySingleton {
    //双重检查锁  volatile 关键字可以让所有线程都能看到共享内存的最新状态
    private static volatile LazySingleton instance = null;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }

        return instance;
    }

}
