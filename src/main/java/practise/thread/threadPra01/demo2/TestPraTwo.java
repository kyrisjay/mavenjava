package practise.thread.threadPra01.demo2;

import practise.thread.threadPra01.demo2.PraTwo;

public class TestPraTwo {
    public static void main(String[] args) {
        PraTwo pt = new PraTwo();

        for (int i = 1; i <= 10; i++) {

            new Thread(pt, "李" + i).start();
        }

    }
}
