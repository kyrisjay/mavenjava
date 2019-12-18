package practise.file;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
    找到指定文件及其子目录下面的所有的txt文件,并且把满足条件的文件全部读取出来写入到另一个txt文件里面去
    (使用递归完成)
 */
public class fileDemo {

    static ArrayList arr = new ArrayList();

    public static void getFile(File file) {
        if (file.isDirectory()) {
            File[] file1 = file.listFiles();
            for (int i = 0; i < file1.length; i++) {
                getFile(file1[i]);
            }
        } else {
            if (file.toString().endsWith(".docx") || file.toString().endsWith(".doc")) {
                arr.add(file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/edz/Downloads");
        getFile(file);
        File f = new File("a.text");
        if (!f.exists()) {
            f.createNewFile();
        }
        BufferedWriter bw=new BufferedWriter(new FileWriter(f));
        int count=0;
        while(count<arr.size()){
            bw.write(String.valueOf(arr.get(count)));
            bw.write('\n');
            bw.flush();
            count++;
        }
        bw.close();
    }
}