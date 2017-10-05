public class Rectangle extends Shape {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Point fourthPoint;

    public Rectangle(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.fourthPoint = fourthPoint;
    }

    public Rectangle() {
    }

    public double getSideLength(Point firstPoint, Point secondPoint) {
        return firstPoint.sideLength(secondPoint);
    }

    @Override
    public double getPerimeter() {
        double sideOne = firstPoint.sideLength(secondPoint);
        double sideTwo = firstPoint.sideLength(fourthPoint);
        return sideOne + sideTwo;
    }

    @Override
    public double getArea() {
        return firstPoint.sideLength(secondPoint) * secondPoint.sideLength(thirdPoint);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                ", thirdPoint=" + thirdPoint +
                ", fourthPoint=" + fourthPoint +
                '}' +
                " Perimeter=" + getPerimeter() +
                " . Area=" + getArea();
    }
}
