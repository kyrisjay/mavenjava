package practise.file.serialize;

import java.io.*;

public class BCopyA {
    public static void main(String[] args) throws IOException {
        File file = new File("atest.txt");

        File file1 = new File("btest.txt");
        if (!file1.exists()) {
            file1.createNewFile();
        }
        FileInputStream fis = new FileInputStream(file);
        //将a文本的内容一次行读取出来摆到b数组里面
        byte[] b = new byte[(int) file.length()];
        fis.read(b);
        //将数组转换为字符串
        String s = new String(b);
        //将小写转换成大写
        String s1 = s.replaceAll("l", "L");

        fis.close();
        //将读取到的内容写到btest文本当中
        Writer w = new FileWriter("btest.txt");
        w.write(s1);
        w.close();
    }
}
