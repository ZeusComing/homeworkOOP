import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> translator = new HashMap<>();
        File englishIn = new File("englishIn.txt");
        File uaOut = new File("ukrainianOut.txt");
        try {
            englishIn.createNewFile();
            uaOut.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //FileOperations.writeToFile("hello java", englishIn);
        translator.put("hello", "привіт");
        translator.put("java", "джава");
        //FileOperations.translate(englishIn, uaOut, translator);


    }
}
