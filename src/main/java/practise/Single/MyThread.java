package practise.Single;

public class MyThread extends java.lang.Thread {
    @Override
    public void run() {
        System.out.println(Singleton.getInstance().hashCode());
    }
}
