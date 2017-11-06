import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        String sheldon = "Sheldon";
        String leo = "Leonard";
        String volovits = "Volovitc";
        String kutrapalli = "Kutrapalli";
        String penny = "Penny";
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(sheldon);
        queue.add(leo);
        queue.add(volovits);
        queue.add(kutrapalli);
        queue.add(penny);
        drinkCola(queue, 6);
    }

    private static void drinkCola(ArrayDeque<String> queue,int glasses) {
        try {
            if (glasses < 1) {
                throw new IllegalArgumentException();
            } else {
                for (int i = 0; i < glasses; i++) {
                    String currentDrinker = queue.pollFirst();
                    queue.addLast(currentDrinker);
                    queue.addLast(currentDrinker);
                }
                System.out.println(queue);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Number of drunk cola glesses can't be 0 or negative");
        }
    }
}
