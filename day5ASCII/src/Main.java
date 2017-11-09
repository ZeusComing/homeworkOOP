import java.io.File;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File ogre = new File("ogre6.txt");
        AscArt ogreArt = new AscArt(ogre);
        ogreArt.printMessage("Hello world");

    }
}
