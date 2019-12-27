package practise.genericity.two;

public class Test {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(new Integer[]{4, 16, 7, 8, 9, 10});
        Array<Double> arr2 = new Array<>(new Double[]{7.2, 16.25, 5.25, 20.4, 9.0, 11.7, 13.25, 15.4});

        System.out.println("Integer型:");
        arr.getMax();
        arr.getMin();
        arr.avg2();

        System.out.println("------------");
        System.out.println("Double型:");
        arr2.getMax();
        arr2.getMin();
        arr2.avg();
    }
}
