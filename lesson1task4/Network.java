import java.util.Arrays;

public class Network {
    private String name;
    private int id = 1;
    private String[] numbers = new String[3];

    public Network(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getNumbers() {
        return numbers;
    }

    public void registration(Phone Phone) {
        numbers[id-1] = Phone.getNumber();
        Phone.setNetwork(this.name);
        System.out.println("Number " + Phone.getNumber() + " registered in the " + this.name);
        id++;
    }

    public boolean search(Phone Phone) {
        boolean check = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == Phone.getNumber()) {
                check = true;
                break;
            }
        }
        return check;

    }

    public void printNumbers () {
        for (int i = 0; i < numbers.length ; i++) {
            System.out.println(numbers[i]);
        }
    }
}
