import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Translator enUa = new Translator();
        File englishIn = new File("englishIn.txt");
        File uaOut = new File("ukrainianOut.txt");
        try {
            englishIn.createNewFile();
            uaOut.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //FileOperations.writeToFile("hello java", englishIn);
        enUa.getTranslator().put("hello", "привіт");
        enUa.getTranslator().put("java", "джава");
        //enUa.translate(englishIn, uaOut);


    }
}
