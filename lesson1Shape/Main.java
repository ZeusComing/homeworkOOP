public class  Main {
    public static void main(String[] args) {
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(5, 7);
        Point thirdPoint = new Point(10, 3);
        Shape firstShape = new Triangle(firstPoint, secondPoint, thirdPoint);
        Shape secondShape = new Circle(secondPoint, thirdPoint);
        Shape thirdShape = new Rectangle(new Point(-4, 2), new Point(3, 2), new Point(3, -1), new Point(-4, -1));
        Board shapes = new Board();
        shapes.putOnTheBoard(firstShape, 1);
        shapes.putOnTheBoard(secondShape, 0);
        shapes.putOnTheBoard(thirdShape, 3);
        shapes.putOnTheBoard(thirdShape, 5);
        shapes.putOnTheBoard(firstShape, 2);
        shapes.removeShapeFromPosition(3);
        shapes.shapesInfo();
    }
}
