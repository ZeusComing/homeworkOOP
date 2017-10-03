import sun.nio.ch.Net;

public class Phone {
    private String model;
    private double weight;
    private String number;
    private String network;

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

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public void call(Phone Phone) {
        if ((this.network == Phone.network) && this.number != Phone.number) {
            System.out.println("You are calling " + Phone.number);
        } else {
            System.out.println("Number is incorrect");
        }
    }

}
