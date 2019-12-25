package practise.thread.threadPra02.p01;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockOn {
    private Lock lock1 = new ReentrantLock();

    public void lockTes(Thread thread) {
        lock1.lock();

        System.out.println(thread.getName() + "执行完毕");
        lock1.unlock();
    }
}

