package practise.Single;

public class Test {
    public static void main(String[] args) {
        MyThread th1=new MyThread();
        MyThread th2=new MyThread();
        MyThread th3=new MyThread();
        MyThread th4=new MyThread();
        MyThread th5=new MyThread();

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();



    }
}
