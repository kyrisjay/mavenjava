package practise.strengthenPra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Que {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();//a队列
        Queue<String> queue2 = new LinkedList<String>();//b队列
        ArrayList<String> arrayList = new ArrayList<String>();

        //往a队列添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("e");
        System.out.print("进栈:");

        for (String q : queue) {
            arrayList.add(q);
            System.out.print(q);
        }

        //以倒序的方法取出（a 队列依次加入 list 集合）之中的值，加入 b 对列
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            queue2.offer(arrayList.get(i));
        }
        //打印出栈队列
        System.out.println();
        System.out.print("出栈:");
        for (String q : queue2) {
            System.out.print(q);
        }
    }
}

