public class Trinagle {
    private double sideOne;
    private double sideTwo;
    private double sideThree;
    private boolean verificationOfExistence;

    public Trinagle(double sideOne, double sideTwo, double sideThree) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
        if (sideOne + sideTwo > sideThree && sideTwo + sideThree > sideOne && sideOne + sideThree > sideTwo && sideOne > 0 && sideTwo > 0 && sideThree > 0) {
            this.verificationOfExistence = true;
        }
    }

    public Trinagle() {
    }

    public double getArea() {
        double semiPerimeter = (sideOne + sideTwo + sideThree) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - sideOne) * (semiPerimeter - sideTwo) * (semiPerimeter - sideThree));
    }

    public void print() {
        if (verificationOfExistence == false) {
            System.out.println(Trinagle.this + " this trinagle does not exist");
        } else {
            System.out.println(Trinagle.this + " area of this trinagle = " + Trinagle.this.getArea());
        }
    }

    @Override
    public String toString() {
        return "Trinagle{" +
                "sideOne=" + sideOne +
                ", sideTwo=" + sideTwo +
                ", sideThree=" + sideThree +
                '}';
    }
}
