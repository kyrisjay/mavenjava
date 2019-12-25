package example.thread.synchAndLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockNotWait {
    private Lock lock = new ReentrantLock();

    public void lockTes(Thread thread) throws InterruptedException {
        if (lock.tryLock(3000, TimeUnit.MICROSECONDS)) {
            try {
                System.out.println(thread.getName() + "进来了...获取当前锁");

                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(thread.getName() + "发生了异常...释放了锁");
            } finally {
                System.out.println(thread.getName() + "正常执行完毕..释放了锁....");
                lock.unlock();//主动释放锁
            }
        } else {
            System.out.println(thread.getName() + "没有获取到锁...被其他线程占用了....");
        }
    }
}
