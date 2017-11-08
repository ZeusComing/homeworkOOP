import java.io.*;
import java.util.*;

public class FileOperations {

    public static void writeToFile(Map.Entry<String, String> translate, File file) {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(file, true))) {
            printWriter.println(translate);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String text, File file) {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(file, true))) {
            printWriter.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] getStringArray(File file) {
        if (file != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String resultString = "";
                for (String text = ""; (text = br.readLine()) != null; ) {
                    resultString += text;
                }
                String[] result = resultString.split("[- ,;:.!?\\s]+");
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void saveToDisk (Map<String, String> translator, String filePath) {
        File file = new File(filePath);
        List<Map.Entry<String, String>> entryList = new ArrayList<>(translator.entrySet());
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("File create error");
        }
        for (int i = 0; i < entryList.size(); i++) {
            writeToFile(entryList.get(i), file);
        }
    }

    public static void addToTranslatorInteractive(Map<String, String> translator) {
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
            translator.put(enText, uaText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void translate(File englistIn, File ukrainianOut, Map<String, String> translator) {
        String[] enWords = getStringArray(englistIn);
        StringBuilder sb = new StringBuilder();
        for (String enWord: enWords) {
            sb.append(translator.get(enWord) + " ");
        }
        writeToFile(sb.toString(), ukrainianOut);
    }
    
}
