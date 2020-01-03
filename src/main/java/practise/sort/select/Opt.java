package practise.sort.select;

import java.util.Arrays;

/**
 * 选择排序
 * 从数组中找到最小的元素，和第一个位置的元素互换
 * 从第二个位置开始，找到最小的元素，和第二个位置的元素互换.....
 * 直到选出array.length-1个较小元素，剩下的最大的元素自动排在最后一位
 */
public class Opt {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void Opt_s(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;//找出当前最小元素位置
                }
            }
            if (arr[minIndex] != arr[i]) {
                swap(arr, minIndex, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 5, 2, 8, 9, 10, 20, 13, 17};
        Opt_s(arr);
        System.out.println(Arrays.toString(arr));

    }
}
