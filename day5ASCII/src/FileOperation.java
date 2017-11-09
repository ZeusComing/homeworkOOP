import java.io.*;

public class FileOperation {

    public static String[][] readFile(File file) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(file))) {
            String[][] temp = new String[26][6];
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 6; j++) {
                   temp[i][j] = br.readLine();
                }
            }
            return temp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
