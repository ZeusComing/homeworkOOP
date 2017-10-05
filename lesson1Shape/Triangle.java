public class Triangle extends Shape {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;

    }

    public Triangle() {
    }

    @Override
    public double getArea() {
        double semiPerimeter = getPerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - firstPoint.sideLength(secondPoint))
                * (semiPerimeter - firstPoint.sideLength(thirdPoint))
                * (semiPerimeter - secondPoint.sideLength(thirdPoint)));

    }

    @Override
    public double getPerimeter() {
        return firstPoint.sideLength(secondPoint) + firstPoint.sideLength(thirdPoint) + secondPoint.sideLength(thirdPoint);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                ", thirdPoint=" + thirdPoint +
                '}' +
                " Perimeter=" + getPerimeter() +
                " . Area=" + getArea();
    }
}
