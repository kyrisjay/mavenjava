package example.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Receive {

    public static void main(String[] args) {
        File file = new File("timg.jpg");
        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        InputStream is = null;
        OutputStream os = null;
        ServerSocket so = null;

        try {
            so = new ServerSocket(6666);
            Socket s = so.accept();
            is = new BufferedInputStream(s.getInputStream());
            byte[] by = new byte[499415];
            int d;
            os = new BufferedOutputStream(new FileOutputStream(file));
            while ((d = is.read(by)) != -1) {
                os.write(by, 0, d);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}