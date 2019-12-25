package practise.thread.threadPra01.demo2;
/*
    现在有一个旅行队10个人,探险进入一线天,这个一线天每次只能过一个人,每个人过的时间是20秒,
    现在10个人通过该一线天,请输出每个人经过一线天的顺序和姓名
 */

public class PraTwo implements Runnable {

    int count = 1;
    Object lock = new Object();

    @Override
    public void run() {
        show();
    }

    public void show() {
        try {
            Thread.currentThread().join(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock) {
            try {
                Thread.currentThread().join(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count <= 10) {
                System.out.println(Thread.currentThread().getName() + "第" + (count++) + "个过一线天");
            }
        }
    }
}

