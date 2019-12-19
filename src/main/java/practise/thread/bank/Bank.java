package practise.thread.bank;

/*
    模范 一个账户 1000块钱 :
    两个人 A B 分别在柜台和ATM机 取钱 A每次取钱100 B每次取200 最终在控制台输出每个人取钱数
 */
public class Bank implements Runnable {
    static int account = 100000;
    static int sumA = 0;
    static int sumB = 0;

    @Override
    public void run() {

        while (account > 0) {
            synchronized (Bank.class) {
                if (Thread.currentThread().getName().equals("A")) {
                    if (account >= 100) {
                        sumA += 100;
                        System.out.println("柜台取钱100元,共取" + sumA + "元");
                        account -= 100;
                    }
                } else {
                    if (account >= 200) {
                        sumB += 200;
                        System.out.println("ATM取钱200元,共取" + sumB + "元");
                        account -= 200;
                    }
                }
            }
        }
    }
}
