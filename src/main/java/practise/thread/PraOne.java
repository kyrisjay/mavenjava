package practise.thread;
/*
    有三个线程,输出200到400之间所有的数据,如果是奇数那么就输出当前线程的名称
 */

public class PraOne implements Runnable {

    int math = 200;

    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            synchronized (this) {
                if (math <= 400) {
                    if (math % 2 == 0) {
                        System.out.println(math);
                    } else {
                        System.out.println(Thread.currentThread().getName() + ",奇数：" + math);
                    }
                    math++;
                } else {
                    flag = false;
                }
            }

        }
    }
}