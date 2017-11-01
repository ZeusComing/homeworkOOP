import java.io.File;

public class Main {
    public static void main(String[] args) {
        File f = new File("Folder");
        Thread thread = new Thread(new Checker(f));
        thread.start();

    }
}
