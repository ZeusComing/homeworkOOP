public class Main {
    public static void main(String[] args) {
        Cat catOne = new Cat("Myrzik","black and white", 5, 4.2);
        Cat catTwo = new Cat("Vaska", "ginger", 1, 3.7);
        System.out.println(catOne.toString());
        System.out.println(catTwo.toString());
        System.out.print(catOne.getName() + ": ");
        catOne.getSleep();
        System.out.print(catTwo.getName() + ": ");
        catTwo.getVoice();
    }
}
