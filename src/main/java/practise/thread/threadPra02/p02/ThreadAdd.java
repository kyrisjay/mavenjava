package practise.thread.threadPra02.p02;

import java.util.concurrent.CountDownLatch;

public class ThreadAdd extends Thread {
    Tool tool;

    public ThreadAdd(String name, Tool tool) {
        super(name);
        this.tool = tool;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (tool) {
                if (tool.flag) {
                    if (tool.countDownLatch.getCount() > 0) {
                        try {
                            Thread.sleep((int) (Math.random() * 1000) + 1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        tool.add();
                        tool.countDownLatch.countDown();
                    } else {
                        try {
                            tool.countDownLatch.await();
                            tool.countDownLatch = new CountDownLatch(2);
                            tool.flag = !tool.flag;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}