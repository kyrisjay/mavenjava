package practise.file;


import java.io.*;
import java.util.ArrayList;

/*
    利用字节流或者换成字节流的方式以指定的格式输入数据 如:xxx,xxx,xxx,最后一个数据以 .号结束，
    一行最多五个数据
 */

public class Writer {
    public static void main(String[] args) throws IOException {
        File f = new File("b.text");
        if (!f.exists()) {
            f.createNewFile();
        }
        ArrayList list = new ArrayList();
        list.add("小鸡");
        list.add("小鸭");
        list.add(14);
        list.add(24.5);
        list.add('a');
        list.add('b');
        list.add('c');
        System.out.println(list);
        OutputStream os = new FileOutputStream(f, true);

        int count = 1;

        while (count < list.size() + 1) {
            os.write(String.valueOf(list.get(count - 1)).getBytes());
            if (count % 5 == 0 && count != 0 || count == list.size()) {
                os.write(".\n".getBytes());
            } else {
                os.write(',');
            }
            count++;
        }
        os.flush();
        os.close();
    }
}