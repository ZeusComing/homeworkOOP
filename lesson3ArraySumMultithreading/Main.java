import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int [] array = new int[200000000];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(3);
        }
        ArraySum arraySum = new ArraySum(array);
        arraySum.calculateSum();
        arraySum.calculateSum();
        MyThread.calculateSum(array, 8);
        MyThread.calculateSum(array, 8);
        MyThread.calculateSum(array, 8);
        MyThread.calculateSum(array, 8);
        MyThread.calculateSum(array, 8);



    }
}
