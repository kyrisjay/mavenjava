package practise.thread.bank;

public class test {
    public static void main(String[] args) {
        Bank bank=new Bank();

        Thread a=new Thread(bank,"A");
        Thread b=new Thread(bank,"B");

        a.start();
        b.start();
    }
}
