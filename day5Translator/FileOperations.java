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

}
