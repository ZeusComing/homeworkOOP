import java.io.File;

public class Main {
    public static void main(String[] args) {
        File startFolder = new File("Start folder");
        File destinationFolder = new File("Destination folder");
        CopyFileThread.startCopy(startFolder, destinationFolder);
    }
}
