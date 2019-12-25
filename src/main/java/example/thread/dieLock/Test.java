package example.thread.dieLock;

public class Test {
    public static void main(String[] args) {

        MyThread mh = new MyThread("张三", true);
        MyThread mh2 = new MyThread("李四", false);

        mh.start();
        mh2.start();

    }
}
