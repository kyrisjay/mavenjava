package practise.thread.threadPra02.p02;

public class test02 {
    public static void main(String[] args) {
        Tool tool = new Tool();

        ThreadAdd t1 = new ThreadAdd("线程A", tool);
        ThreadAdd t2 = new ThreadAdd("线程B", tool);
        TheadReduce t3 = new TheadReduce("线程C", tool);
        TheadReduce t4 = new TheadReduce("线程D", tool);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

