import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("testfile.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
        FileOperations.showChars(file);
    }
}
