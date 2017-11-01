public class ArraySum {
    private int[] arr;

    public ArraySum(int[] arr) {
        this.arr = arr;
    }

    public void calculateSum() {
        long begin = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < this.arr.length ; i++) {
            sum += this.arr[i];
        }
        long time = System.currentTimeMillis() - begin;
        System.out.println("Singlethread metod calculated " + this.arr.length +
                " elements in " + time + "ms. Sum is " + sum);
    }
}
