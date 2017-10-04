public class Phone {
    private String model;
    private double weight;
    private String number;
    private Network network;

    public Phone(String model, double weight, String number) {
        this.model = model;
        this.weight = weight;
        this.number = number;
    }

    public Phone() {
    }

    public String getModel() {
        return model;
    }

    public double getWeight() {
        return weight;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void call (String number) {
        if (this.network == null || this.number == number || !this.network.getSearch(this.number) || !this.network.getSearch(number)) {
            System.out.println("Number is incorrect");
        } else {
            System.out.println("You are calling " + number);
        }
    }

}

