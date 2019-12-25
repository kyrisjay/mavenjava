package example.prectice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceivedServer extends  Thread{
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(6666);
            while (true) {
                byte[] bytes = new byte[499415];
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
                ds.receive(dp);
                byte[] by = dp.getData();
                System.out.println("--->" + dp.getLength());

                String str = new String(by, 0, dp.getLength());
                System.out.println(dp.getAddress().getHostName()+"说："+str);
            }
            //ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

