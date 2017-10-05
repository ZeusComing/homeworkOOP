import java.util.Arrays;

public class Board {
    private Shape[] shapes = new Shape[4];

    public void putOnTheBoard (Shape shape, int position) {
        if (position >= shapes.length) {
            System.out.println("You are trying to put a shape outside the board");
        } else if (alreadyOnTheBoard(shape)) {
            System.out.println("This shape already on the board!");
        } else if (shapes[position] != null) {
            System.out.println("This position already taken");
        } else {
            shapes[position] = shape;
            System.out.println("Now position " + position + " taken by " + shape);
        }
    }

    public void removeShapeFromPosition (int position) {
        shapes[position] = null;
        System.out.println("Now position " + position + " is empty");
    }

    public void shapesInfo() {
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] == null) {
                System.out.println(i + " position is empty");
            } else {
                System.out.println(i + " position taken by " + shapes[i].getClass());
            }
        }
    }

    private boolean alreadyOnTheBoard(Shape shape) {
        boolean check = false;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] == shape) {
                check = true;
                break;
            }
        }
        return check;
    }
}
