package practise.file.serialize;

import java.io.*;
import java.util.LinkedList;

public class SerializeStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(new File("c.txt")));
        Student1 stu1 = new Student1("张三", "栖霞", 22);
        Student1 stu = new Student1("张三", "栖霞", 24);

        LinkedList<Student1> arr = new LinkedList<Student1>();
        arr.add(stu);
        arr.add(stu1);

        oos.writeObject(arr);
        oos.flush();
        oos.close();

        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(new File("c.txt")));
        LinkedList<Student1> arr1 = (LinkedList<Student1>) ois.readObject();
        for (int i = 0; i < arr1.size(); i++) {
            Student1 s = arr1.get(i);
            System.out.println(s.getName() + "---" + s.getAddress() + "---" + s.getAge());
        }

    }
}