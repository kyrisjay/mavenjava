package example.tcp;

import java.io.*;

import java.net.Socket;

public class Send {
    public static void main(String[] args) throws FileNotFoundException {
        Socket socket = null;

        BufferedInputStream is = null;
        BufferedOutputStream os = null;
        File file = new File("/Users/edz/desktop/timg.jpg");
        while (true)
        try {
            is = new BufferedInputStream(new FileInputStream(file));
            byte[] bytes = new byte[(int) file.length()];
            socket = new Socket("192.168.10.180", 6666);
            os = new BufferedOutputStream(socket.getOutputStream());
            int d;
            while ((d = is.read(bytes, 0, bytes.length)) != -1) {
                os.write(bytes, 0, d);
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