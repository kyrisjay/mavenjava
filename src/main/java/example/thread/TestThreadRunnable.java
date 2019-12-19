package example.thread;

public class TestThreadRunnable {
    public static void main(String[] args) {
        ThreadRunnable th = new ThreadRunnable();

        Thread t1 = new Thread(th, "A票口");
        Thread t2 = new Thread(th, "B票口");
        Thread t3 = new Thread(th, "C票口");
        Thread t4 = new Thread(th, "D票口");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
