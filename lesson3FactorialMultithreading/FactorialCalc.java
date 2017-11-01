import java.math.BigInteger;

public class FactorialCalc implements Runnable {
    private int n;

    public FactorialCalc(int n) {
        this.n = n;
    }

    public FactorialCalc() {
    }

    private BigInteger factorialCalculate(int n) {
        BigInteger factorial = new BigInteger("1");
        for (int i = 1; i <= n ; i++) {
            factorial = factorial.multiply(new BigInteger("" + i));
        }
        return  factorial;
    }

    @Override
    public void run() {
        Thread th = Thread.currentThread();
        for(int i = 1; i <= this.n; i++) {
            if (th.isInterrupted()) {
                System.out.println(th.getName() + " stop");
                break;
            }
            System.out.println(th.getName() + " -> " + i + " != " + factorialCalculate(i));
        }
    }

    public static void threadCreate(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("Thread " + i + " created");
            Thread thread = new Thread(new FactorialCalc(i));
            thread.setName("Thread - " + i);
            thread.start();
        }
    }
}
