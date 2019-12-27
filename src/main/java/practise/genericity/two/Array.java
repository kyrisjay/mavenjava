package practise.genericity.two;

public class Array<T extends Number> {

    private T[] array;

    public Array(T[] array) {
        this.array = array;
    }

    public void getMax() {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].doubleValue() > max.doubleValue()) {
                max = array[i];
            }
        }
        System.out.println("最大值为:" + max);
    }

    public void getMin() {
        T min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].doubleValue() < min.doubleValue()) {
                min = array[i];
            }
        }
        System.out.println("最小值为:" + min);
    }

    public void avg() {
        double avg;
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i].doubleValue();
        }
        avg = sum / array.length;
        System.out.println("平均值为:" + avg);
    }
    public void avg2() {
        Integer avg;
        Integer sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i].intValue();
        }
        avg = sum / array.length;
        System.out.println("平均值为:" + avg);
    }

}
