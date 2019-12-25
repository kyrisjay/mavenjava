package example.thread.synchAndLock;

public class LockDemo {
    public static void main(String[] args) {

        final LockNotWait lockTest = new LockNotWait();
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    lockTest.lockTes(Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程A");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockTest.lockTes(Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程B");
        t.start();
        //t.interrupt();
        t2.start();
    }
}
