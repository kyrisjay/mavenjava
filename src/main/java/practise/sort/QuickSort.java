package practise.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 设要排序的数组是A[0]……A[N-1]，首先任意选取一个数据（通常选用数组的第一个数）作为关键数据，
 * 然后将所有比它小的数都放到它前面，所有比它大的数都放到它后面，这个过程称为一趟快速排序。
 * 值得注意的是，快速排序不是一种稳定的排序算法，也就是说，多个相同的值的相对位置也许会在算法结束时产生变动
 */
public class QuickSort {
    //正序
    public static void QS_asc(int arr[], int low, int high) {//传入代排数据，low是基准数据，high是长度
        checks(arr, low, high);
        int temp = 0;//默认的空容器
        int start = low;//把基准位置定为排序的头部位置的下标，代表最左边的下标
        int end = high;//把最大长度作为最右边的下标，尾部下标
        int standRadVal = arr[start];//初始基准数据为基准位置的数据

        while (end > start) {//退出条件 low>=high
            //从后向前排，若后边的数据大于基准数据，满足正序的数据格式，就把右边的下标向前移动，直到找到比基准位置数据小的数据
            while (end > start && arr[end] > standRadVal)
                end--;
            if (arr[end] < standRadVal) {//交换右边比左边小的数据
                swap(arr, end, start, temp);
            }
            //从前向后排，若前边的数据大于基准数据，就把右边的下标向后移动，直到找到比基准位置数据大的数据
            while (end > start && arr[start] < standRadVal)
                start++;
            if (arr[start] > standRadVal) {//交换
                swap(arr, end, start, temp);
            }
        }

        if (end < high) {//若结束时的尾部下标位置小于（不等于）初始最大位置的下标
            QS_asc(arr, end + 1, high);
        }
        if (start > low) {//若结束时的头部下标位置大于（不等于）初始位置的下标
            QS_asc(arr, low, start - 1);
        }
    }

    //倒序
    public static void QS_desc(int arr[], int low, int high) {
        checks(arr, low, high);
        int temp = 0;//默认的空容器
        int start = low;//把基准位置定为排序的头部位置的下标，代表最左边的下标
        int end = high;//把最大长度作为最右边的下标，尾部下标
        int standRadVal = arr[start];//初始基准数据为基准位置的数据

        while (end > start) {//退出条件 low>=high

            while (end > start && arr[end] < standRadVal)
                end--;
            if (arr[end] > standRadVal) {
                swap(arr, end, start, temp);
            }
            while (end > start && arr[start] > standRadVal)
                start++;
            if (arr[start] < standRadVal) {
                swap(arr, end, start, temp);
            }
        }
        if (end < high) {
            QS_desc(arr, end + 1, high);
        }
        if (start > low) {
            QS_desc(arr, low, start - 1);
        }
    }

    public static void checks(int[] arr, int low, int high) {//检测传入数据是否合法，避免报错
        if (arr.length - 1 <= 0 || arr == null || low < 0 || high > arr.length - 1) {
            return;//不合法就返回
        }
    }



    public static void swap(int[] arr, int end, int start, int temp) {//交换的方法
        temp = arr[end];//每次交换之后基准位置就会变成start或end，因为从后面向前排序，end为基准右边交换的数据
        arr[end] = arr[start];//start 为左边需要交换的数据，覆盖原有数据
        arr[start] = temp;//最后把temp容器中的数据覆盖原有数据
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 5, 2, 8, 9, 10, 20, 13, 17};
        QS_desc(arr, 0, arr.length - 1);
        System.out.print("降序排序后：" + Arrays.toString(arr));

        QS_asc(arr,0,arr.length-1);
        System.out.println("正序排序后：" + Arrays.toString(arr));
    }
}