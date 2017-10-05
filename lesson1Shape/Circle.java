public class Circle extends Shape {
    private Point firstPoint;
    private Point secondPoint;

    public Circle(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public Circle() {
    }

    public double getPerimeter() {
        double radius = firstPoint.sideLength(secondPoint);
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        double radius = firstPoint.sideLength(secondPoint);
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                '}' +
                " Radius=" + firstPoint.sideLength(secondPoint) +
                " .Perimeter=" + getPerimeter() +
                " . Area=" + getArea();
    }
}
