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

    public void registration(String number, Phone phone) {
        numbers[id-1] = number;
        phone.setNetwork(this);
        System.out.println("Number " + number + " registered in the " + this.name);
        id++;
    }

    public boolean getSearch(String number) {
        boolean check = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
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
