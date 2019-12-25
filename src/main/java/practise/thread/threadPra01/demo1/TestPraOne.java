package practise.thread.threadPra01.demo1;


import practise.thread.threadPra01.demo1.PraOne;

public class TestPraOne {
    public static void main(String[] args) {
        PraOne po=new PraOne();

        Thread th1=new Thread(po,"线程1");
        Thread th2=new Thread(po,"线程2");
        Thread th3=new Thread(po,"线程3");

        th1.start();
        th2.start();
        th3.start();
    }
}
