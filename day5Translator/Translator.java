import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Translator {
    private Map<String, String> translator;

    public Translator() {
        this.translator = new HashMap<>();
    }

    public Map<String, String> getTranslator() {
        return translator;
    }

    public void setTranslator(Map<String, String> translator) {
        this.translator = translator;
    }

    public void addInteractive() {
        String enText;
        String uaText;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in))) {
            System.out.println("Write english word");
            do {
                enText = br.readLine();
                if (enText.length() == 0) {
                    System.out.println("Empty string. Try again");
                }
            } while (enText.length() == 0);
            System.out.println("Write translate");
            do {
                uaText = br.readLine();
                if (enText.length() == 0) {
                    System.out.println("Empty string. Try again");
                }
            } while (uaText.length() == 0);
            this.translator.put(enText, uaText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void translate(File englistIn, File ukrainianOut) {
        String[] enWords = FileOperations.getStringArray(englistIn);
        StringBuilder sb = new StringBuilder();
        for (String enWord: enWords) {
            sb.append(this.translator.get(enWord) + " ");
        }
        FileOperations.writeToFile(sb.toString(), ukrainianOut);
    }


}
