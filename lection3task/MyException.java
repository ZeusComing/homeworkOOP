public class MyException extends Exception {
    @Override
    public String getMessage() {
        return " Group is full";
    }
}
