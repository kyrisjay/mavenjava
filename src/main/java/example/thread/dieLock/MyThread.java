package example.thread.dieLock;

import com.sun.deploy.security.SelectableSecurityManager;

public class MyThread extends Thread {

     boolean flag;//告诉线程要执行哪一块

    public MyThread(String name,boolean flag) {
        super(name);
        this.flag = flag;
    }

    @Override
    public void run() {

        if (flag) {
            synchronized (DieLock.objA) {
                System.out.println(Thread.currentThread().getName() + "拿到来objA");
                synchronized (DieLock.objB) {
                    System.out.println(Thread.currentThread().getName() + "拿到来objB");
                }
            }
        } else {
            synchronized (DieLock.objB) {
                System.out.println(Thread.currentThread().getName() + "拿到来objB");
                synchronized (DieLock.objA) {
                    System.out.println(Thread.currentThread().getName() + "拿到来objA");
                }
            }
        }
    }
}
