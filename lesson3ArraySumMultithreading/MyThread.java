public class MyThread implements Runnable{
    public static int totalSum = 0;
    private int sum = 0;
    private int[] array;


    public MyThread(int[] array) {
        this.array = array;
    }

    public synchronized static int getTotalSum() {
        return totalSum;
    }

    public synchronized static void setTotalSum(int totalSum) {
        MyThread.totalSum = totalSum;
    }

    public static int[][] getArrays(int[] startArray ,int threads) {
        int currentStep = 0;
        int step = startArray.length/threads;
        int [][] result = new int[threads][];
        for (int i = 0; i < threads; i++) {
            result[i] = new int[startArray.length/threads];
            for (int j = 0; j < step; j++) {
                result[i][j] = startArray[j + step*i];
            }
            currentStep += step;
        }
        return result;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length ; i++) {
            sum += array[i];
        }
        setTotalSum(getTotalSum() + sum);
    }

    public static void calculateSum(int[] startArray, int threads) {
        int[][] ints = getArrays(startArray,threads);
        long begins = System.currentTimeMillis();
        for (int i = 0; i < threads; i++) {
            Thread mt = new Thread (new MyThread(ints[i]));
            mt.start();
            try {
                mt.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long times = System.currentTimeMillis() - begins;
        System.out.println("Multithread metod calculated " + startArray.length +
                " elements in " + times + "ms. Sum is " + getTotalSum());
        setTotalSum(0);
    }
}
