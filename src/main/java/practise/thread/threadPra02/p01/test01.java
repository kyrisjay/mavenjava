package practise.thread.threadPra02.p01;

/*
    现在有三个线程,如何保持三个线程按照顺序执行
 */
public class test01 {
    public static void main(String[] args) throws InterruptedException {
        final LockOn lock = new LockOn();

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                lock.lockTes(Thread.currentThread());
            }
        }, "线程A");

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {

                lock.lockTes(Thread.currentThread());
            }
        }, "线程B");

        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {

                lock.lockTes(Thread.currentThread());
            }
        }, "线程C");

        t.start();

        t2.start();

        t3.start();
    }
}
