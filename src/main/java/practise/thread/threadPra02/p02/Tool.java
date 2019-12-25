package practise.thread.threadPra02.p02;

import java.util.concurrent.CountDownLatch;

public class Tool {

    //为了解决高并发的问题 CountDownLatch 类似于一个线程计数器 使一个线程或者多个线程完成各自的工作谈后再继续执行
    CountDownLatch countDownLatch = new CountDownLatch(2);//表示有2个线程计数器

    boolean flag = true;

    public void add() {

        System.out.println(Thread.currentThread().getName() + "执行++操作");
    }

    public void reduce() {

        System.out.println(Thread.currentThread().getName() + "执行--操作");
    }
}
